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
public class Match {
    private Player player1 = null;
    private Player player2 = null;
    private String MATCH_ID = "";
    private ArrayList<String> cardPlayed;
    
    
    Match(){
        
    }
    
    Match(String setMatchID){
       this.MATCH_ID = setMatchID;
    }
    
    Match(String setMatchId, Player setPlayer1, Player setPlayer2){
        this.player1 = setPlayer1;
        this.player2 = setPlayer2;
        this.MATCH_ID = setMatchId;
        
        
    }
    
    public void setPlayer1(Player setPlayer1){
        this.player1 =  setPlayer1;
    }
    
    public void setPlayer2(Player setPlayer2){
        this.player2 = setPlayer2;
    }
    
    public void setMatchID(String setMatchId){
        this.MATCH_ID = setMatchId;
    }
    
    
    public  Player getWinningPlayer(){
        if(this.player1.getPlayerMatchResult()){
            return this.player1;
        }
        return this.player2;
    }
    
    public ArrayList<String> cardsUsedInMatch(){
        return this.cardPlayed;
    }
    
    public ArrayList<MagicCard> getWinningPlayersCards(){
        return getWinningPlayer().getCardsUsed();
    }
    
    public ArrayList<MagicCard> getLosingPlayersCards(){
        return getLosingPlayer().getCardsUsed();
    }
    
    
    public Player getLosingPlayer(){
        if(!this.player1.getPlayerMatchResult()){
            return this.player1;
        }
        return this.player2;
    }
    
    public Player getPlayer1(){
        return this.player1;
    }
    public Player getPlayer2(){
        return this.player1;
    }
    
    public String getMatchID(){
        return this.MATCH_ID;
    }
    
    public String toString(){
        return ("Match ID: " + getMatchID() + " Player 1 " + getPlayer1() + " Player 2 " + getPlayer2());
    }
}
