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
public class MorseCode {
    //private final static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //private final static char[] letters = {'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    //private final static String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
    private final static String[] morseCode = {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    private static BTree morseTree;
    
    private static void writeMorseCodeSheet(){
        char[] letterChar = letters.toCharArray();
        morseTree = new BTree();
        Node root = new Node(' ');
        morseTree.setRoot(root);
        
        for (int i = 0; i <morseCode.length; i++){
            morseTree.setCurrent(root);
            for(char letter : morseCode[i].toCharArray()){
                if (letter == '.'){
                    if (morseTree.getCurrent().getLeft() == null){
                        morseTree.getCurrent().setLeft(new Node(' '));
                    }
                    morseTree.setCurrent(morseTree.getCurrent().getLeft());
                } 
                else{
                    if (morseTree.getCurrent().getRight() == null){
                        morseTree.getCurrent().setRight(new Node(' '));
                    }
                    morseTree.setCurrent(morseTree.getCurrent().getRight());
                }
            }
            morseTree.getCurrent().setLetter(letterChar[i]);
        }
    }
    
    public static String encode(String input){
        String result = "";
        String space = "";
        String seprator = "";
        input = input.toUpperCase();
        for (String word : input.split(" ")){
            for (char letter : word.toCharArray()){
                if (letters.indexOf(letter) == -1){
                    return "invaild letter in the Sring!";
                }
                result += (space + morseCode[letters.indexOf(letter)]);
                space = " ";
            }
            space = "";
            result += "   ";
        }
        return result;
    }
    
    public static String decode(String input){
        writeMorseCodeSheet();
        String result = "";
        for(String word : input.split("   ")){
            for(String section : word.split(" ")){
                morseTree.setCurrent(morseTree.getRoot());
                for(char symbol : section.toCharArray()){
                    if (symbol == '.'){
                            if (morseTree.getCurrent().getLeft() == null){
                                return "Fail to decode!";
                            }
                            morseTree.setCurrent(morseTree.getCurrent().getLeft());
                        }
                    else if(symbol == '-'){
                            if (morseTree.getCurrent().getRight() == null){
                                return "Fail to decode!";
                            }
                            morseTree.setCurrent(morseTree.getCurrent().getRight());
                        }
                    else{
                        return "Not a correct Morse Code format!";
                    }
                }
                result += morseTree.getCurrent().getLetter();
            }
            result += " ";
        }
        return result;
    }
}
