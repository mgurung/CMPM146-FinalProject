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
    private Player player1;
    private Player player2;
    private String MATCH_ID = "";
    private ArrayList<String> cardPlayed;
    
    
    
    Match(String setMatchID){
       this.MATCH_ID = setMatchID;
    }
    
    Match(String setMatchId, Player setPlayer1, Player setPlayer2){
        
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
    
    
    public  Player getWinnerPlayer(){
        if(this.player1.getPlayerMatchResult() == true){
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
    
    
}
