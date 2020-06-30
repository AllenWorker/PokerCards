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
public class Node {
    private char letter;
    private Node left;
    private Node right;
    
    public Node(char letter)
    {
        this.letter = letter;
        left = null;
        right = null;
    }
    
    public void setLeft(Node node)
    {
        if (left == null)
            left = node;
    }
    
    public void setRight(Node node)
    {
        if (right == null)
            right = node;
    }
    
    public Node getLeft()
    {
        return left;
    }
    
    public Node getRight()
    {
        return right;
    }
    
    public char getLetter()
    {
        return letter;
    }
    
    public void setLetter(char letter)
    {
        this.letter = letter;
    }
}
