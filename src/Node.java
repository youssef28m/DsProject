/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */
public class Node {
    private final int id;
    private Node next;
    
    public Node (int id){
        this.id = id;
        this.next = null;
        
    }
    public int getId(){
        return id;
    }
    public Node getNext(){
        return next;
        
    }
    public void setNext(Node next){
        this.next =next;
    }
    
    
}
