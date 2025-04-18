package RegistrationSystemPackage;

/**
 *
 * @author ahmed
 */
class  Node {
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

class StudentNode extends Node {
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


class CourseNode extends Node {
    private int studentsCount;
    private Cell firstCell;

    public CourseNode(int id) {
        super(id);
        this.studentsCount = 0;
        this.firstCell = null;
    }

    // ------------ Getters & Setters ------------
    public int getStudentsCount() {
        return studentsCount;
    }

    public Cell getFirstCell() {
        return firstCell;
    }

    public void setFirstCell(Cell firstCell) {
        this.firstCell = firstCell;
    }

    // إضافة طالب للكورس
//    public void addStudent(StudentNode student) {
//        Cell newCell = new Cell(student, this);
//        newCell.setNextStudentForThisCourse(firstCell);
//        firstCell = newCell;
//        studentsCount++;
//    }

    
}