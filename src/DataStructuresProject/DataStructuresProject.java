package DataStructuresProject;
import RegistrationSystemPackage.RegistrationSystem;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
public class DataStructuresProject {

    public static void main(String[] args) {
        try {
            // main method start

            System.out.println("Hello in main method");

            // This is the system
            RegistrationSystem mySystem1 = new RegistrationSystem(2,7,30); // 2,7,30 is required in project pdf

            mySystem1.addStudent(1001);
            mySystem1.addStudent(1002);
            mySystem1.addStudent(1003);
            mySystem1.addStudent(1004);
            mySystem1.addStudent(1005);
            mySystem1.removeStudent(1001);
            mySystem1.addCourse(54);
            mySystem1.addCourse(55);
            mySystem1.addCourse(56);

            mySystem1.addCourse(57);
            mySystem1.addCourse(58);
            mySystem1.removeCourse(54);

            mySystem1.addStudentToCourse(1002, 56);
            mySystem1.addStudentToCourse(1002, 55);
            mySystem1.addStudentToCourse(1002, 57);
            mySystem1.addStudentToCourse(1003, 57);
            mySystem1.addStudentToCourse(1004, 57);

            mySystem1.displayStudentsOfCourse(57);
            mySystem1.displayStudentsOfCourse(55);
            mySystem1.displayStudentsOfCourse(333);
            mySystem1.displayStudentsOfCourse(58);

            mySystem1.undo();
            mySystem1.undo();
            mySystem1.undo();
            mySystem1.undo();

            
            // main method End
        } catch (Exception e) {
            System.out.println( e.getMessage() != null ? "Error: "+e.getMessage() : "Error in : "+e );
        }
    }
    
}
