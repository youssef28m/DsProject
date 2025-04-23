package RegistrationSystemPackage;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
class Cell {

    private final StudentNode studentNode;
    private final CourseNode courseNode;

    private Cell nextStudentForThisCourse;
    private Cell nextCourseForThisStudent;
    private Cell prevStudentForThisCourse;
    private Cell prevCourseForThisStudent;

    Cell(StudentNode studentNode, CourseNode courseNode) {
        this.studentNode = studentNode;
        this.courseNode = courseNode;
    }

    StudentNode getStudentNode() {
        return studentNode;
    }
    CourseNode getCourseNode() {
        return courseNode;
    }

    int getStudent_ID(){
        return studentNode.getId();
    }

    int getCourse_ID(){
        return courseNode.getId();
    }

    void set_next_student(Cell c1){
        this.nextStudentForThisCourse =c1;
    }

    void set_next_course(Cell c1){
        this.nextCourseForThisStudent = c1;
    }

    Cell get_next_student(){
        // if you got null so there is no next cell or enrollment
        return nextStudentForThisCourse;
    }

    Cell get_next_course(){
        // if you got null so there is no next cell or enrollment
        return nextCourseForThisStudent;
    }
}