/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.wa.tafe.pokercards;
import java.util.Scanner;
/**
 *
 * @author AllenWorker
 */
public class PlayCards {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CardList poker = new CardList();
        char esc = 'U';
        while( esc != 'Y'){
            System.out.println("Please input number!");
            System.out.println("1:Playing Cards 2:Morse Code");
            int number = scan.nextInt();
            switch(number){
                case 1:
                    while (number != 0){
                        int rank = 0;
                        int suit = 0;
                        String[] result;
                        System.out.println("Please input number! Input 0 to return");
                        System.out.println("1:Insert all 2:Insert one 3:Delete all 4:Delete one 5:Find card 6:Show All");
                        number = scan.nextInt();
                        switch(number){
                            case 1:
                                System.out.println("Insert all cards");
                                poker.insert("Spades", "ACE");
                                poker.insert("Spades", "2");
                                poker.insert("Spades", "3");
                                poker.insert("Spades", "4");
                                poker.insert("Spades", "5");
                                poker.insert("Spades", "6");
                                poker.insert("Spades", "7");
                                poker.insert("Spades", "8");
                                poker.insert("Spades", "9");
                                poker.insert("Spades", "10");
                                poker.insert("Spades", "J");
                                poker.insert("Spades", "Q");
                                poker.insert("Spades", "K");

                                poker.insert("Hearts", "ACE");
                                poker.insert("Hearts", "2");
                                poker.insert("Hearts", "3");
                                poker.insert("Hearts", "4");
                                poker.insert("Hearts", "5");
                                poker.insert("Hearts", "6");
                                poker.insert("Hearts", "7");
                                poker.insert("Hearts", "8");
                                poker.insert("Hearts", "9");
                                poker.insert("Hearts", "10");
                                poker.insert("Hearts", "J");
                                poker.insert("Hearts", "Q");
                                poker.insert("Hearts", "K");

                                poker.insert("Diamonds", "ACE");
                                poker.insert("Diamonds", "2");
                                poker.insert("Diamonds", "3");
                                poker.insert("Diamonds", "4");
                                poker.insert("Diamonds", "5");
                                poker.insert("Diamonds", "6");
                                poker.insert("Diamonds", "7");
                                poker.insert("Diamonds", "8");
                                poker.insert("Diamonds", "9");
                                poker.insert("Diamonds", "10");
                                poker.insert("Diamonds", "J");
                                poker.insert("Diamonds", "Q");
                                poker.insert("Diamonds", "K");

                                poker.insert("Clubs", "ACE");
                                poker.insert("Clubs", "2");
                                poker.insert("Clubs", "3");
                                poker.insert("Clubs", "4");
                                poker.insert("Clubs", "5");
                                poker.insert("Clubs", "6");
                                poker.insert("Clubs", "7");
                                poker.insert("Clubs", "8");
                                poker.insert("Clubs", "9");
                                poker.insert("Clubs", "10");
                                poker.insert("Clubs", "J");
                                poker.insert("Clubs", "Q");
                                poker.insert("Clubs", "K");
                                System.out.println("Done!");
                                break;

                            case 2:
                                
                                System.out.println("Input number to choose the suits");
                                System.out.println("1: Spades 2:Hearts 3:Diamonds 4:Clubs");
                                suit = scan.nextInt();
                                if (suit < 1 || suit > 4) {return;}
                                System.out.println("Input number 1-13!");
                                rank = scan.nextInt();
                                if (rank < 1 || rank > 13) {return;}
                                result = suitAndRank(suit,rank);
                                poker.insert(result[0], result[1]);
                                break;
                                
                            case 3:
                                System.out.println("Delete All");
                                while(!poker.isEmpty()){
                                    poker.remove();
                                }
                                break;
                                
                            case 4:
                                System.out.println("Input number to choose the suits");
                                System.out.println("1: Spades 2:Hearts 3:Diamonds 4:Clubs");
                                suit = scan.nextInt();
                                if (suit < 1 || suit > 4) {return;}
                                System.out.println("Input number 1-13!");
                                rank = scan.nextInt();
                                if (rank < 1 || rank > 13) {return;}
                                result = suitAndRank(suit,rank);
                                poker.delete(result[0], result[1]);
                                break;
                                
                            case 5:
                                System.out.println("Input number to choose the suits");
                                System.out.println("1: Spades 2:Hearts 3:Diamonds 4:Clubs");
                                suit = scan.nextInt();
                                if (suit < 1 || suit > 4) {return;}
                                System.out.println("Input number 1-13!");
                                rank = scan.nextInt();
                                if (rank < 1 || rank > 13) {return;}
                                result = suitAndRank(suit,rank);
                                System.out.println(poker.find(result[0], result[1]).display());
                                break;
                                
                            case 6:
                                System.out.println("Show All");
                                System.out.println(poker.toString());
                                break;
                                
                            default:
                                break;
                        }
                    }
                    break;
                    
                case 2:
                    while (number != 0){
                        System.out.println("Please input number! Input 0 to return");
                        System.out.println("1:Encode 2:Decode");
                        number = scan.nextInt();
                        switch(number){
                            case 1:
                                System.out.println("Encode");
                                System.out.println(MorseCode.encode(scan.next()));
                                break;

                            case 2:
                                System.out.println("Decode");
                                System.out.println(MorseCode.decode(scan.next()));
                                break;
                                
                            default:
                                break;
                        }
                    }
                    break;
                    
                default:
                    break;
            }
            System.out.println("\nDo you want to exit (Type y or n) \n");
            System.out.flush();;
	    esc = Character.toUpperCase(scan.next().charAt(0));                       
        }
        
        
       /*
       System.out.println(poker.toString());
        
       poker.delete("Clubs", "K");
       poker.delete("Spades", "ACE");
       poker.delete("Clubs", "Q");
       poker.delete("Spades", "2");
       poker.delete("Clubs", "10");
        
        System.out.println(poker.toString());
        System.out.println(poker.find("Clubs", "8").display());
        
        
        System.out.println(MorseCode.encode("Hello World0"));
        System.out.println(MorseCode.decode(".... . .-.. .-.. ---   .-- --- .-. .-.. -.."));
        System.out.println(MorseCode.decode(MorseCode.encode("Hello World")));
        */
    }
    public static String[] suitAndRank(int suit, int rank){
            String[] result = new String[2];
            switch(suit){
                case 1:
                    result[0] = "Spades";
                    break;
                case 2:
                    result[0] = "Hearts";
                    break;
                case 3:
                    result[0] = "Diamonds";
                    break;
                    
                case 4:
                    result[0] = "Clubs";
                    break;
                default:
                    break;
            }
            if (rank > 1 && rank <= 10){
                result[1] = Integer.toString(rank);
            } else {
                if (rank == 1) {result[1] = "ACE";}
                if (rank == 11) {result[1] = "J";}
                if (rank == 12) {result[1] = "Q";}
                if (rank == 13) {result[1] = "K";}
            }
            return result;
        }
}
