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
            RegistrationSystem mySystem1 = new RegistrationSystem(2,7,20,30); // 2,7,20,30 is required in project pdf
            
            mySystem1.addStudent();
            mySystem1.addCourse();
            
            
            
            
            
            
            
            
            
            
            
            
            // main method End
        } catch (Exception ex) {
            System.out.println("Error was happend: \n"+ex);
        }
    }
    
}
