/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */
public class CourseNode {
    private int studentsCount;
    private Cell firstCell;

    public CourseNode(int id) {
        //super(id);
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
