/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_trainer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Jose
 */
public class FXMLDocumentController implements Initializable {
    
    
    // load spread sheet
    public SpreadSheet worksheet =  new SpreadSheet("gamedata.xlsx");
    public MagicData gameData = new MagicData(worksheet);
    
    @FXML
    private Label alert;
    
    @FXML
    private TextField file_name;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        worksheet.printWorkSheet();
    }
    @FXML
    private void printFirstRow(ActionEvent event) {
        worksheet.printCurrentRow();
    }
    @FXML
    private void NextRow(ActionEvent event) {
        worksheet.moveToNextRow();
    }
    @FXML
    private void PrevRow(ActionEvent event) {
        worksheet.moveToPrevRow();
    }
    
    @FXML
    private void PrintMatch(ActionEvent event) {
        gameData.printAllMatches();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    
    
}
