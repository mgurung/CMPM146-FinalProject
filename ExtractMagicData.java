/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_trainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class ExtractMagicData {
    private XSSFSheet sheet;
    private ArrayList<String> playerNames = new ArrayList<>();
    private ArrayList<Integer> LandsPlayed = new ArrayList<>();
    public ExtractMagicData(XSSFSheet sheet){
        this.sheet = sheet;
        
    }
    
    public void returnPlayerName(){
        
    }
    
}
