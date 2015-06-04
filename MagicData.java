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
public class MagicData {
    private XSSFSheet sheet;
    private ArrayList<Match> match;
    private SpreadSheet datasheet;
    private ArrayList<MagicCard> cardsUsed;
    public MagicData(SpreadSheet newDataSheet){
        this.datasheet = newDataSheet;
        this.datasheet.moveToNextRow();
        Player player1;
        Player player2;
        Match newMatch;
        
        while (!this.datasheet.isRowLast()){
            newMatch = new Match(extractMacthId());
            player1 = createPlayerFromData();
            this.datasheet.moveToNextRow();
            player2 = createPlayerFromData();
            newMatch.setPlayer1(player1);
            newMatch.setPlayer2(player2);
            match.add(newMatch);
        }
    }
    
   
    
    private String extractMacthId(){
        
        return this.datasheet.getCurrentRow().getCell(2).getStringCellValue();
    }
    private Player createPlayerFromData(){
        Player newPlayer = new Player();
        
        String playerName = this.datasheet.getCurrentRow().getCell(3).getStringCellValue();
        newPlayer.setPlayerName(playerName);
        
        int LandsPlayed = (int)this.datasheet.getCurrentRow().getCell(5).getNumericCellValue();
        newPlayer.setPlayerLandPlayed(LandsPlayed);
        
        int white = (int)this.datasheet.getCurrentRow().getCell(6).getNumericCellValue();        
        int red = (int)this.datasheet.getCurrentRow().getCell(11).getNumericCellValue();
        int blue = (int)this.datasheet.getCurrentRow().getCell(7).getNumericCellValue();
        int green =(int) this.datasheet.getCurrentRow().getCell(10).getNumericCellValue();
        int black = (int)this.datasheet.getCurrentRow().getCell(8).getNumericCellValue();
        
        newPlayer.setCardTypeUsed(white, blue, black, green, red);
        
        int wentFirst = (int)this.datasheet.getCurrentRow().getCell(15).getNumericCellValue();
        
        if(wentFirst == 1){
           newPlayer.setPlayerWentFirst(true);
        }
        
        int wonMatch = (int)this.datasheet.getCurrentRow().getCell(13).getNumericCellValue();
        newPlayer.setIfWon(wonMatch);

        newPlayer.setCardsUsed(extractCards());
        
        
        return newPlayer;
    }
    
    private ArrayList<String> extractCards(){
        String cards = this.datasheet.getCurrentRow().getCell(12).getStringCellValue() + "[";
        ArrayList<String> extractedCards = new ArrayList<>();
        String splitData[];
        while(cards.contains("[")){
            splitData = cards.split("\\[",2);
            if(!splitData[0].isEmpty()){
                System.out.println("card: " + splitData[0]);
                extractedCards.add(splitData[0]);
            }
            cards = splitData[1];
        }
        return extractedCards;
    }
    private ArrayList<Match> getMatches(){
        return this.getMatches();
    }
    
    
}
