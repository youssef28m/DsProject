package RegistrationSystemPackage;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
public class RegistrationSystem {

    
    private StudentsList studentsList = new StudentsList();
    private CoursesList coursesList = new CoursesList();
    
    private int minCoursesForStudent;
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

    public void addStudent(){
        int newID = studentsList.getLastAdded()+1;
        studentsList.add(newID);
        System.out.println("Student added with ID :"+newID);


    }
    public void addCourse(){
        int newID = coursesList.getLastAdded()+1;
        coursesList.add(newID);
        System.out.println("Course added with ID"+newID);
    }



    public void removeStudent(int id) {
        StudentNode student = studentsList.findStudentById(id);
        if (student != null) {
            studentsList.remove(id);
            System.out.println("Student with ID " + id + " has been removed.");
            // You might also need to delete the associated Cells/enrollments
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void removeCourse(int id) {
        CourseNode course = coursesList.findCourseById(id);
        if (course != null) {
            coursesList.remove(id);
            System.out.println("Course with ID " + id + " has been removed.");
            // You might also need to delete all enrolled students' Cells
        } else {
            System.out.println("Course with ID " + id + " not found.");
        }
    }
    
    
    
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
