package RegistrationSystemPackage;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
public class Cell {

    private final int student_ID;
    private final int course_ID;
    private Cell nextStudentForThisCourse;
    private Cell nextCourseForThisStudent;


    public Cell(int student_ID,int course_ID){
        this.student_ID = student_ID;
        this.course_ID = course_ID;
    }

    public int getStudent_ID(){
        return student_ID;
    }
    public int getCourse_ID(){
        return course_ID;
    }



    public void set_next_student(Cell c1){
        this.nextStudentForThisCourse =c1;
    }
    public void set_next_course(Cell c1){
        this.nextCourseForThisStudent = c1;
    }

    public Cell get_next_student(){
        //if you got null so there is no next cell or enrollment;

            return nextStudentForThisCourse;
    }
    public Cell get_next_course(){

        //if you got null so there is no next cell or enrollment;
            return nextCourseForThisStudent;
    }



}
