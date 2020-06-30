/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.wa.tafe.pokercards;

/**
 *
 * @author AllenWorker
 */
public class PokerCard {
    String suit;
    String rank;
    PokerCard next;
    PokerCard previous;
    
    public PokerCard(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public String display(){
        return rank + " of " + suit;
    }
}
