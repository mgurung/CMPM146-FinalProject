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
    private SpreadSheet datasheet;

    private ArrayList<Match> match =  new ArrayList<>();
    private ArrayList<MagicCard> cardsUsed = new ArrayList<>();
    
    public MagicData(SpreadSheet newDataSheet){
        this.datasheet = newDataSheet;
        this.datasheet.moveToNextRow();
        Player player1;
        Player player2;
        Match newMatch;
        
        while (!this.datasheet.isRowLast()){
            newMatch = new Match(extractMacthId());
            player1 = createPlayerFromData();
            
            // move to next row in spreadsheet
            this.datasheet.moveToNextRow();
            
            player2 = createPlayerFromData();
           
            newMatch.setPlayer1(player1);
            newMatch.setPlayer2(player2);
            
            this.match.add(newMatch);
        }
    }
    
   
    
    // extracts the match id from the spreadsheet of that specific row
    private String extractMacthId(){
        
        return this.datasheet.getCurrentRow().getCell(1).toString();
    }
    
    
    // creates player form spreadsheet
    private Player createPlayerFromData(){
        
        Player newPlayer = new Player();
        int white = 0;
        int red = 0;
        int blue = 0;
        int green = 0;
        int black = 0;
        // set player name by getting data from cell 3 
        String playerName = this.datasheet.getCurrentRow().getCell(2).toString();
        newPlayer.setPlayerName(playerName);
        
        // sets lands played 
        int LandsPlayed = (int)this.datasheet.getCurrentRow().getCell(4).getNumericCellValue();
        newPlayer.setPlayerLandPlayed(LandsPlayed);
        
        // get cards used by player
        if(checkIfValidCell(6)){
        white = (int)this.datasheet.getCurrentRow().getCell(6).getNumericCellValue();  
        }
        if(checkIfValidCell(11)){
        red = (int)this.datasheet.getCurrentRow().getCell(11).getNumericCellValue();
        }
        if(checkIfValidCell(7)){
        blue = (int)this.datasheet.getCurrentRow().getCell(7).getNumericCellValue();
        }
        if(checkIfValidCell(10)){
        green =(int)this.datasheet.getCurrentRow().getCell(10).getNumericCellValue();
        }
        if(checkIfValidCell(8)){
        black = (int)this.datasheet.getCurrentRow().getCell(8).getNumericCellValue();
        }
        
        // set card types used to player being created
        newPlayer.setCardTypeUsed(white, blue, black, green, red);
        // check if player went first
        
        int wentFirst = (int)this.datasheet.getCurrentRow().getCell(16).getNumericCellValue();
        
        // set if player went first
        if(wentFirst == 1){
           newPlayer.setPlayerWentFirst(true);
        }
        
        int gameResults = (int)this.datasheet.getCurrentRow().getCell(13).getNumericCellValue();
        newPlayer.setIfWon(gameResults);

        newPlayer.setCardsUsed(extractCards(gameResults));
        return newPlayer;
    }
    
    private boolean checkIfValidCell(int cellindex){
        if(this.datasheet.getCurrentRow().getCell(cellindex).toString().equalsIgnoreCase("NULL")){
            return false;
        }
        return true;
    }
    // extract cards from spreadsheet cell
    private ArrayList<MagicCard> extractCards(int gameResults){
        String cards = this.datasheet.getCurrentRow().getCell(12).getStringCellValue() + "[";
        ArrayList<MagicCard> extractedCards = new ArrayList<>();
        String splitData[];
        while(cards.contains("[")){
            splitData = cards.split("\\[",2);
            if(!splitData[0].isEmpty()){
                extractedCards.add(createCardFromData(splitData[0], gameResults));
            }
            cards = splitData[1];
        }
        return extractedCards;
    }
  
    // creates a card based on the card name and also records if the card was used
    // in a game in which the player won or lost
    
    public MagicCard createCardFromData(String cardName, int gameResults){
        MagicCard newCard = new MagicCard(cardName,gameResults);
        if (this.cardsUsed.contains(newCard)){
             this.cardsUsed.get(this.cardsUsed.indexOf(newCard)).cardAppeared();
             if(gameResults == 1){
                  this.cardsUsed.get(this.cardsUsed.indexOf(newCard)).won();
             }
             else{
                  this.cardsUsed.get(this.cardsUsed.indexOf(newCard)).lost();
             }
        }
        else{
            this.cardsUsed.add(newCard);
        }
        
        return newCard;
    }
    
    
    // returns a list of all the matches obtained from the spreadsheet
    public ArrayList<Match> getMatches(){
        return this.match;
    }

    // returns all cards use in all of the matches
    // use this to get statistical information about the cards used in the matches
    // it this gives a accurate number of wins and loses per card and the winrates
    // of the cards 
    public ArrayList<MagicCard> getAllCardsUsed(){
      return  this.cardsUsed;
    }
    
    public void printAllCardsUsed(){
        int count = 0;
        while (count < this.cardsUsed.size()){
            System.out.println("card name: "+ this.cardsUsed.get(count).toString());
        }
    }
    
    
    public void printAllMatches(){
        for (Match matches :  match){
            System.out.println(matches.toString());
        }
    }
}




