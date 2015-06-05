/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_trainer;

/**
 *
 * @author Jose
 */
public class MagicCard {
    private String cardName = "";
    // nummber of times the card has appered in overall matches
    private int used = 0;
    private double winRate = 0.0;
    private double losingRate = 0.0;
    private int win = 0;
    private int lost = 0;
    
   MagicCard (String setName){
       this.cardName = setName;
   }
   
   MagicCard (String setName,int result){
       setGameResults(result);
       this.cardName = setName;
   }
   
   // sets the card name
   public void setCardName(String setName){
       this.cardName = setName;
   }
    
    // increments the number of times this card has been played in a game
   public void cardAppeared(){
       this.used +=1;
   }
   
   // sets the cards game result
   public void setGameResults(int result){
       if (result == 1){
           this.win += 1;
       }
       else{
           this.lost += 1;
       }
   }
   
   // increments the number of times this card has been played in a game in which
   // the player won the match
   public void won(){
       this.win += 1;
   }
   
   // increments the number of times this card has been played in a game in which
   // the player lost the match 
    public void lost(){
       this.lost += 1;
   }
   
   
   // returns the name of the card 
   public String getCardName(){
       return this.cardName;
   }
    
  
   // returns the number of times the card has appeared in a match regardless
   // of whether it was in a winning players cards or loosing players cards
   public int appearences(){
       return this.used;
   }
   
   // returns the number of times the card has appeared in a winning player
   // deck
   public int wins(){
       return this.win;
   }
   
   // returns the number of times the card has appeared in a losing team
   public int loses(){
       return this.lost;
   }
   
   
   public double getWinRate(){
       return this.winRate = this.win/this.used;
   }
   
   public double getLosingRate(){
       return this.losingRate = this.lost/this.used;
   }
   
   public boolean equalsCard(String otherCardName){
       if (this.cardName == otherCardName){
           return true;
       }
       return false;
   }
   
   public String toString(){
       return ("card name: " + getCardName());
   }
}

