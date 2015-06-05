/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_trainer;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jose
 */
public class Player {
    
    // player info
    private String name = "";
    private int landsplayed = 0;
    private ArrayList<MagicCard> cardsused =  new ArrayList<>();
    
    // card types 
    private boolean blue = false;
    private boolean red = false;
    private boolean green = false;
    private boolean black = false;
    private boolean white = false;

    private int mulligans = 0;

    
    private boolean gameWon = false;
    private String matchID = "";
    private boolean playedFirst = false;
    
    
    Player(){
        
    }
    
    Player (String setName){
        this.name = setName;
    }
    
    
    // returns the player name
    public String getPlayerName(){
        return this.name;
    }
    
    
    // returns a list of cards used by the player
    public ArrayList<MagicCard> getCardsUsed(){
        return this.cardsused;
    }
    
    
    // returns the card types used by the player
    public String getCardTypesUsed(){
        String cardtypeused = "";
        if (red){
            cardtypeused += " red ";
        }
        if (blue){
            cardtypeused += "blue";
        }
        if (black){
            cardtypeused += "black";
        }
        if (green){
            cardtypeused += "green";
        }
        if (white){
            cardtypeused += "white";
        }
        
        return cardtypeused;
    }
    
    // returns the number of land cards played by the player
    public int getPlayerLandPlayed(){
        return landsplayed;
    }
    
    
    // returns the result of the player in the match, true if player won
    // false if player lost 
    public boolean getPlayerMatchResult(){
        return this.gameWon;
    }
    
    
    // sets the player name
    public void setPlayerName(String playerName){
        this.name = playerName;
    }
    
    
    // sets the cards used by the player in the match
    public void setCardsUsed(ArrayList<MagicCard> cards){
        this.cardsused.addAll(cards);
    }
    
    
    // sets the number of lands played
    public void setPlayerLandPlayed(int setlandsplayed){
        this.landsplayed = setlandsplayed;
    }
    
    // set if player won the match based on the data
    public void setIfWon(int won){
        if (won == 1){
            this.gameWon = true;
        }
    }
    
    // set whether if the player went first
    public void setPlayerWentFirst(boolean wentFirst){
        this.playedFirst = wentFirst;
    }
    
    
    // returns true of player went first false if not
    public boolean didPlayerGoFirst(){
        return this.playedFirst;
    }
    
    public void setCardTypeUsed(int white, int blue, int black, int green, int red){
        if (red == 1){
            this.red = true;
        }
        if (blue == 1){
            this.blue = true;
        }
        if (green == 1){
            this.green = true;
        }
        if (black == 1){
            this.black = true;
        }
        if (white == 1){
            this.white = true;
        }
    }
    
    
    public String toString(){
        String cards = "";
        for(MagicCard card : cardsused){
            cards =  cards + " , " + card.getCardName();
        }
        
        return ("Player name: " + getPlayerName() + " cards: " + cards + "lands Played" + getPlayerLandPlayed());
    }
    
    
}
