/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_trainer;

import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class Player {
    
    // player info
    private String name = "";
    private int landsplayed = 0;
    private ArrayList<String> cardsused;
    
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
    
    public String getPlayerName(){
        return this.name;
    }
    
    public ArrayList<String> getCardsUsed(){
        return this.cardsused;
    }
    
    
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
    
    public int getPlayerLandPlayed(){
        return landsplayed;
    }
    
    public boolean getPlayerMatchResult(){
        return this.gameWon;
    }
    
    public void setPlayerName(String playerName){
        this.name = playerName;
    }
    
    public void setCardsUsed(ArrayList<String> cards){
        this.cardsused = cards;
    }
    
    public void setPlayerLandPlayed(int setlandsplayed){
        this.landsplayed = setlandsplayed;
    }
    
    public void setIfWon(int won){
        if (won == 1){
            this.gameWon = true;
        }
    }
    
    public void setPlayerWentFirst(boolean wentFirst){
        this.playedFirst = wentFirst;
    }
    
    
    
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
        System.out.println("name: " + this.name );
        return ("name: " + this.name);
    }
    
    
}
