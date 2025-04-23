package RegistrationSystemPackage;

/**
 *
 * @author ahmed
 */
class Node {
    private final int id;
    private Node next;
    Cell firstCell;

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
        this.firstCell = null;
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

    void removeAllCoursesOfMe() {
// sparse table TODO
        Cell curr = firstCell;
        while (curr != null) {
            CourseNode course = RegistrationSystemMain.system.coursesList.getCourseNodeById(curr.getCourse_ID());
// Remove from course's list
            Cell prev = null, c = course.firstCell;
            while (c != null) {
                if (c.getStudent_ID() == getId()) {
                    if (prev == null) course.firstCell = c.get_next_student();
                    else prev.set_next_student(c.get_next_student());
                    course.studentsCount--;
                    break;
                }
                prev = c;
                c = c.get_next_student();
            }
            curr = curr.get_next_course();
        }
// Clear student's list
        firstCell = null;
        coursesCount = 0;
    }



}


class CourseNode extends Node {

    private CourseNode next;


    int studentsCount;

    CourseNode(int id) {
        super(id);
        this.studentsCount = 0;
        this.firstCell = null;
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

    void removeAllStudentsOfMe() {
// sparse table TODO
        Cell curr = firstCell;
        while (curr != null) {
            StudentNode student =
                    RegistrationSystemMain.system.studentsList.getStudentNodeById(curr.getStudent_ID());
// Remove from student's list
            Cell prev = null, s = student.firstCell;
            while (s != null) {
                if (s.getCourse_ID() == getId()) {
                    if (prev == null) student.firstCell = s.get_next_course();
                    else prev.set_next_course(s.get_next_course());
                    student.coursesCount--;
                    break;
                }
                prev = s;
                s = s.get_next_course();
            }
            curr = curr.get_next_student();
        }
// Clear course list
        firstCell = null;
        studentsCount = 0;
    }
    
}