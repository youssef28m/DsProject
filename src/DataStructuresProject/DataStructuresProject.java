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
            mySystem1.addCourse(54);
            mySystem1.addCourse(55);
            mySystem1.addCourse(56);
            mySystem1.removeStudent(1001);
            mySystem1.removeCourse(54);

            
            
            
            
            
            
            
            

            
            
            // main method End
        } catch (Exception e) {
            System.out.println( e.getMessage() != null ? "Error: "+e.getMessage() : "Error in : "+e );
        }
    }
    
}
