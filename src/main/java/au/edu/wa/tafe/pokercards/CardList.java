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
public class CardList {
    private PokerCard first;
    
    public CardList(){
        first = null;
    }
    
    public void insert(String suit, String rank){
        PokerCard poker = new PokerCard(suit, rank);
        poker.next = first;
        if (first != null){
            first.previous = poker;
        }
        first = poker;
    }
    
    public PokerCard remove(){
        PokerCard current = first;
        PokerCard previous;
         PokerCard next;
        while (current.next != null){
            current = current.next;
        }
        previous = current;
        if (current.next == null && current.previous == null){
            first = null;
        }else if (current.next == null){
            previous = current.previous;
            previous.next = null;
        }
        else if(current.previous == null){
            first = current.next;
            first.previous = null;
        }
        else{
            previous = current.previous;
            next = current.next;
            previous.next = current.next;
            next.previous = current.previous;
        }
        
        return previous;
    }
    
    public PokerCard delete(String suit, String rank){
        PokerCard current = first;
        PokerCard previous;
        PokerCard next;
        PokerCard delete;
        while(!(current.suit.equals(suit) && current.rank.equals(rank))){
            if(current.next == null){
                return null;
            }
            else{
                current = current.next;
            }
        }
        delete = current;
        if (current.next == null && current.previous == null){
            first = null;
        }else if (current.next == null){
            previous = current.previous;
            previous.next = null;
        }
        else if(current.previous == null){
            first = current.next;
            first.previous = null;
        }
        else{
            previous = current.previous;
            next = current.next;
            previous.next = current.next;
            next.previous = current.previous;
        }
        return delete;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public PokerCard find (String suit, String rank){
        PokerCard current = first;
        while(!(current.suit.equals(suit) && current.rank.equals(rank))){
            if(current.next == null){
                return null;
            }
            else{
                current = current.next;
            }
        }
        return current;
    }
    
    public int size(){
        PokerCard current = first;
        int size = 0;
        while(current.next != null){
            current = current.next;
            size++;
        }
        return size;
    }
    
    @Override
    public String toString(){
        PokerCard current = first;
        int cardIndex = 1;
        String result ="";
        while (current != null){
            result += ("Card " + cardIndex + " " + current.display() + "\n");
            cardIndex++;
            current = current.next;
        }
        return result;
    }
}
