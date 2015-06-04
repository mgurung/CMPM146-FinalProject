/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_trainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jose
 */
public class SpreadSheet {
    
    private String  Fileurl;
    private FileInputStream file = null;
    private FileOutputStream outfile = null;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet = null;
    private Row currentRow;
    private Cell currentCell;
    private ArrayList<String> columnTitles;
    private ArrayList<Object> RowData;
    
    public SpreadSheet(){
        
    }
    
    public SpreadSheet(String FileUrl){
        this.Fileurl = FileUrl;
        this.loadWorkBook();
    }
    
    public void setFileUrl(String FileUrl){
        this.Fileurl = FileUrl;
    }
    

    // losds the spread sheet if file exists, and then sets the first
    // sheet of the spread sheet as the active sheet
    public void loadWorkBook(){
        try {
            file = new FileInputStream(new File(this.Fileurl));
            //Create Workbook instance holding reference to .xlsx file
            this.workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            this.sheet = this.workbook.getSheetAt(0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpreadSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpreadSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.currentRow = this.sheet.getRow(0);
    }
    
    public void printWorkSheet(){
         Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " : ");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + " : ");
                            break;
                    }
                }
                System.out.println("");
            }
    }
    
    public Row getCurrentRow(){
        return this.currentRow;
    }
    
    public Cell getCurrentCell(){
        return this.currentCell;
    }
    
    
  
    public void moveToNextCell(){
        if (this.sheet == null){
           throw new RuntimeException("Error: moveNextCell(), there is no spreadsheet assigned");
        }
        if(this.currentCell.getColumnIndex()!= this.currentRow.getLastCellNum()){
           this.currentCell = this.currentRow.getCell((this.currentCell.getColumnIndex() + 1));
        }
        else{
            throw new RuntimeException("Error: moveNextCell(), there is no next cell");
        }
    }  
    
     public void moveToPrevCell(){
        if (this.sheet == null){
           throw new RuntimeException("Error: movePrevCell(), there is no spreadsheet assigned");
        }
        if(this.currentCell.getColumnIndex()!= this.currentRow.getFirstCellNum()){
           this.currentCell = this.currentRow.getCell((this.currentCell.getColumnIndex() - 1));
        }
        else{
            throw new RuntimeException("Error: movePrevCell(), there is no next cell");
        }
    } 
    
    // moves to next Row in the specified spreadsheet, will throw
    // an exception if there is no specified spreadsheet or if there 
    // is not next row 
    public void moveToNextRow(){
         if (this.sheet == null){
            throw new RuntimeException("Error: moveToNextRow(), there is no spreadsheet assigned");
        }
        if(this.currentRow.getRowNum() != this.sheet.getLastRowNum()){
           this.currentRow = this.sheet.getRow(this.currentRow.getRowNum() + 1);
        }
        else{
            throw new RuntimeException("Error: getNextRow(), there is no next row");
        }
    }
    
    // moves to next Row in the specified spreadsheet, will throw
    // an exception if there is no specified spreadsheet or if there 
    // is not prev row 
    public void moveToPrevRow(){
        
        if (this.sheet == null){
            throw new RuntimeException("Error: moveToPrevRow(), there is no spreadsheet assigned");
        }
        if(this.currentRow.getRowNum() != 0){
           this.currentRow = this.sheet.getRow(this.currentRow.getRowNum() - 1);
        }
        else{
            throw new RuntimeException("Error: getNextRow(), there is no next row");
        }
    }
    
    // returns true if the current row is the last row returns false if it is not
    public boolean isRowLast(){
        if(this.currentRow.getRowNum() == this.sheet.getLastRowNum()){
            return true;
        }
        return false;
    }
    
     // returns true if the current row is the last row returns false if it is not
    public boolean isCellLast(){
        if(this.currentRow.getRowNum() == this.sheet.getLastRowNum()){
            return true;
        }
        return false;
    }
    
    
     public ArrayList<Object> getRowData(){
        
         // clears the data stored in Row data 
        this.RowData.clear();
         
        Iterator<Cell> cellIterator = this.currentRow.cellIterator();
          
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        this.RowData.add(cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        this.RowData.add(cell.getStringCellValue());
                        break;
                }
            }
            
        return this.RowData;
    }
    
    
    public void printCurrentRow(){
        
        String toPrint = "";
         Iterator<Cell> cellIterator = this.currentRow.cellIterator();
             
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " : ");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + " : ");
                        break;
                }
            }
            System.out.println("");
    }
    
    public void printCurrentCell(){
        System.out.println("print cell: "+ this.currentCell.toString());
    }
    
    
    
    }
