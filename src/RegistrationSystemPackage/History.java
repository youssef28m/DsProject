package RegistrationSystemPackage;
import java.util.*;

/**
 *
 * @author: 
 */
class History {
    private final Stack<String> undoStack = new Stack<>();
    private final Stack<String> redoStack = new Stack<>();
    private final RegistrationSystem regSystem;

    History(RegistrationSystem regSystem) {
        this.regSystem = regSystem;
    }

    void addActionToHistory(String action) {
        undoStack.push(action);
        redoStack.clear();
    }

    void undo() {
        // Remember to print about what done (add, remove and etc)
        System.out.println("undo");

        int studentId=0, courseId=0;
        boolean print = true;

        if (!undoStack.isEmpty()) {

            String action = undoStack.pop();
            redoStack.push(action);

            List<String> actionList = Arrays.asList(action.split(" "));
            studentId = Integer.parseInt(actionList.get(1));
            courseId = Integer.parseInt(actionList.get(2));
            print = Boolean.parseBoolean(actionList.get(3));

            if (actionList.get(0).equals("addStudentToCourse")) {


                while (true) {
                    byte status = regSystem.removeStudentFromCourse(studentId, courseId, print, false);

                    if (status == 1) {
                        System.out.println("Undo done successfully");
                        break;
                    } else if (status == 0) {
                        System.out.println("Undo warning, Enrollment of student "+studentId+" and course "+courseId+" is already not exist.");
                        break;
                    } else if (status == -1) {
                        regSystem.addStudent(studentId);
                    } else if (status == -2) {
                        regSystem.addCourse(courseId);
                    } else {
                        System.out.println("Code Error"); // Must not happen never during code testing
                        break;
                    }
                }




            } else if (actionList.get(0).equals("removeStudentFromCourse")) {

                while (true) {
                    byte status = regSystem.addStudentToCourse(studentId, courseId, print, false);

                    if (status == 1) {
                        System.out.println("Undo done successfully");
                        break;
                    } else if (status == 0) {
                        System.out.println("Undo warning, Enrollment of student "+studentId+" and course "+courseId+" is already exist.");
                        break;
                    } else if (status == -1) {
                        regSystem.addStudent(studentId);
                    } else if (status == -2) {
                        regSystem.addCourse(courseId);
                    } else {
                        System.out.println("Code Error"); // Must not happen never during code testing
                        break;
                    }
                }

            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }

        } else {
            System.out.println("History is empty, can not undo.");
        }

    }

    void redo() {
        // Remember to print about what done (add, remove and etc)

        int studentId=0, courseId=0;
        boolean print = true;

        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);

            List<String> actionList = Arrays.asList(action.split(" "));
            studentId = Integer.parseInt(actionList.get(1));
            courseId = Integer.parseInt(actionList.get(2));
            print = Boolean.parseBoolean(actionList.get(3));

            if (actionList.get(0).equals("addStudentToCourse")) {
                while (true) {
                    byte status = regSystem.addStudentToCourse(studentId, courseId, print, false);

                    if (status == 1) {
                        System.out.println("Redo done successfully");
                        break;
                    } else if (status == 0) {
                        System.out.println("Redo warning, Enrollment of student "+studentId+" and course "+courseId+" is already exist.");
                        break;
                    } else if (status == -1) {
                        regSystem.addStudent(studentId);
                    } else if (status == -2) {
                        regSystem.addCourse(courseId);
                    } else {
                        System.out.println("Code Error"); // Must not happen never during code testing
                        break;
                    }
                }

            } else if (actionList.get(0).equals("removeStudentFromCourse")) {


                while (true) {
                    byte status = regSystem.removeStudentFromCourse(studentId, courseId, print, false);

                    if (status == 1) {
                        System.out.println("Redo done successfully");
                        break;
                    } else if (status == 0) {
                        System.out.println("Undo warning, Enrollment of student "+studentId+" and course "+courseId+" is already not exist.");
                        break;
                    } else if (status == -1) {
                        regSystem.addStudent(studentId);
                    } else if (status == -2) {
                        regSystem.addCourse(courseId);
                    } else {
                        System.out.println("Code Error"); // Must not happen never during code testing
                        break;
                    }
                }

            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }

        } else {
            System.out.println("There no action to redo");
        }


    }


}
