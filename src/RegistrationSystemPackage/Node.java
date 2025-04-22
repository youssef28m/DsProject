package RegistrationSystemPackage;

/**
 *
 * @author ahmed
 */
class Node {
    private final int id;
    private Node next;
    Cell firstcell;

    Node (int id){
        this.id = id;
        this.next = null;
        
    }
    int getId(){
        return id;
    }
    Node getNext(){
        return next;
        
    }
    void setNext(Node next){
        this.next =next;
    }

}

class StudentNode extends Node {

    private StudentNode next;


    int coursesCount;

    
    StudentNode(int id){
        super(id);
        this.coursesCount = 0;
        this.firstcell = null;
    }


    StudentNode getNext(){
        return next;
    }

    void setNext(StudentNode next){
        this.next = next;
    }

    int getCountOfCourses() {
        return coursesCount;
    }

    void removeAllCoursesOfMe(){
        // sparse table TODO
    }

    
}


class CourseNode extends Node {

    private CourseNode next;


    int studentsCount;

    CourseNode(int id) {
        super(id);
        this.studentsCount = 0;
        this.firstcell = null;
    }


    CourseNode getNext(){
        return next;
    }

    void setNext(CourseNode next){
        this.next = next;
    }

    int getCountOfStudents() {
        return studentsCount;
    }

    void removeAllStudentsOfMe(){
        // sparse table TODO
    }
    
}