package RegistrationSystemPackage;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
public class RegistrationSystem {

    
    private StudentsList studentsList = new StudentsList();
    private CoursesList coursesList = new CoursesList();
    
    private final int minCoursesForStudent;
    private final int maxCoursesForStudent;
    
    private final int minStudentsForCourse;
    private final int maxStudentsForCourse;

    public RegistrationSystem(int minCoursesForStudent, int maxCoursesForStudent, int minStudentsForCourse, int maxStudentsForCourse) throws java.lang.Exception {
        if (minCoursesForStudent < 0 || minStudentsForCourse < 0 || maxCoursesForStudent < minCoursesForStudent || maxStudentsForCourse < minStudentsForCourse){
            throw Exception("Check Correct min and max values.");
        }
        
        this.minCoursesForStudent = minCoursesForStudent;
        this.maxCoursesForStudent = maxCoursesForStudent;
        this.minStudentsForCourse = minStudentsForCourse;
        this.maxStudentsForCourse = maxStudentsForCourse;
    }

    private Exception Exception(String message) {
        throw new UnsupportedOperationException(message); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addStudent(){}
    public void addCourse(){}
    
    
    
    public void removeStudent(){}
    public void removeCourse(){}
    
    
    
    public void getLastStudentAdded(){}
    public void getLastCourseAdded(){}
    
    
    
    public void getAllStudentsList(){}
    public void getAllCoursesList(){}
    public void displayAllStudentsList(){}
    public void displayAllCoursesList(){}
    
    
    public void addStudentToCourse(){}
    public void removeStudentFromCourse(){}
    
    
    
    public void getCoursesOfStudent(){}
    public void getStudentsOfCourse(){}
    public void displayCoursesOfStudent(){}
    public void displayStudentsOfCourse(){}
    
    
    
    public void isFullCourse(){}
    public void isNormalStudent(){}

    
    
}
