/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */
public class StudentNode extends Node {
    private int coursesCount;
    private Cell firstcell;
    
    public StudentNode(int id){
        super(id);
        this.coursesCount = 0;
        this.firstcell = null;
    }
    public void printNextNode(){
        Node nextNode = getNext();
        if(nextNode != null){
            System.out.println("next node ID" + nextNode.getId());
        }
    }
       
    
    
    
}
