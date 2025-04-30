package DataStructuresProject;
import RegistrationSystemPackage.RegistrationSystem;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            RegistrationSystem system = new RegistrationSystem(2, 7, 30);
            boolean running = true;

            while (running) {
                System.out.println("\n=== Main Menu ===");
                System.out.println("1. Student");
                System.out.println("2. Course");
                System.out.println("3. Undo");
                System.out.println("4. Redo");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1" -> studentMenu(system, scanner);
                    case "2" -> courseMenu(system, scanner);
                    case "3" -> system.undo();
                    case "4" -> system.redo();
                    case "0" -> {
                        running = false;
                        System.out.println("Exiting. See you next time.");
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }

    private static void studentMenu(RegistrationSystem system, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List All Students");
            System.out.println("4. Show Courses of a Student");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Drop Student from Course");
            System.out.println("7. Check if a Student is Normal");
            System.out.println("8. Show Last Student Added");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter new Student ID: ");
                    int id = readInt(scanner);
                    system.addStudent(id);
                }
                case "2" -> {
                    System.out.print("Enter Student ID to remove: ");
                    int id = readInt(scanner);
                    system.removeStudent(id);
                }
                case "3" -> system.displayAllStudentsList();
                case "4" -> {
                    System.out.print("Enter Student ID: ");
                    int sid = readInt(scanner);
                    system.displayCoursesOfStudent(sid);
                }
                case "5" -> {
                    System.out.print("Enter Student ID to enroll: ");
                    int sid = readInt(scanner);
                    System.out.print("Enter Course ID: ");
                    int cid = readInt(scanner);
                    system.addStudentToCourse(sid, cid);
                }
                case "6" -> {
                    System.out.print("Enter Student ID to drop: ");
                    int sid = readInt(scanner);
                    System.out.print("Enter Course ID: ");
                    int cid = readInt(scanner);
                    system.removeStudentFromCourse(sid, cid);
                }
                case "7" -> {
                    System.out.print("Enter Student ID: ");
                    int sid = readInt(scanner);
                    system.displayIsNormalStudent(sid);
                }
                case "8" -> system.displayLastStudentAdded();
                case "0" -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void courseMenu(RegistrationSystem system, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. List All Courses");
            System.out.println("4. Show Students of a Course");
            System.out.println("5. Check if a Course is Full");
            System.out.println("6. Show Last Course Added");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter new Course ID: ");
                    int id = readInt(scanner);
                    system.addCourse(id);
                }
                case "2" -> {
                    System.out.print("Enter Course ID to remove: ");
                    int id = readInt(scanner);
                    system.removeCourse(id);
                }
                case "3" -> system.displayAllCoursesList();
                case "4" -> {
                    System.out.print("Enter Course ID: ");
                    int cid = readInt(scanner);
                    system.displayStudentsOfCourse(cid);
                }
                case "5" -> {
                    System.out.print("Enter Course ID: ");
                    int cid = readInt(scanner);
                    system.displayIsFullCourse(cid);
                }
                case "6" -> system.displayLastCourseAdded();
                case "0" -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }
}
