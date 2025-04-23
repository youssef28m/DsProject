package RegistrationSystemPackage;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
class Cell {

    private final int student_ID;
    private final int course_ID;

    // need "prev" for easy remove enrollments
    // in my opinion: not need setters and getters for those variables
    private Cell nextStudentForThisCourse;
    private Cell nextCourseForThisStudent;
    private Cell prevStudentForThisCourse;
    private Cell prevCourseForThisStudent;

    Cell(int student_ID,int course_ID){
        this.student_ID = student_ID;
        this.course_ID = course_ID;
    }

    int getStudent_ID(){
        return student_ID;
    }

    int getCourse_ID(){
        return course_ID;
    }

    void set_next_student(Cell c1){
        this.nextStudentForThisCourse =c1;
    }

    void set_next_course(Cell c1){
        this.nextCourseForThisStudent = c1;
    }

    Cell get_next_student(){
        //if you got null so there is no next cell or enrollment;
        return nextStudentForThisCourse;
    }

    Cell get_next_course(){
        //if you got null so there is no next cell or enrollment;
        return nextCourseForThisStudent;
    }
}