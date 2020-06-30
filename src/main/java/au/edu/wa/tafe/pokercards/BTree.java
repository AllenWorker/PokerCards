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
public class BTree {
    private Node root;
    private Node currentNode;
    
    public BTree()
    {
        root = null;
    }
    
    public Node getRoot()
    {
        return root;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    public int countNode()
    {
        return countNode(root);
    }
    
    private int countNode(Node node)
    {
        int count = 1;
        if (node == null)
        {
            return 0;
        }
        else 
        {
            count += countNode(node.getLeft());
            count += countNode(node.getRight());
            return count;
        }
    }
    
    public Node getCurrent()
    {
        return currentNode;
    }
    
    public void setCurrent(Node node)
    {
        this.currentNode = node;
    }
    
    public void setRoot(Node root)
    {
        this.root = root;
    }
}
