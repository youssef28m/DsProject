package RegistrationSystemPackage;
import java.util.*;

/**
 *
 * @author: 
 */
class History {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private RegistrationSystem regSystem;

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
                regSystem.removeStudentFromCourse(studentId, courseId, print, false);
            } else if (actionList.get(0).equals("removeStudentFromCourse")) {
                regSystem.addStudentToCourse(studentId, courseId, print, false);
            } else {
                System.out.println("action is not valid");
            }

        } else {
            System.out.println("history is empty");
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
                regSystem.addStudentToCourse(studentId, courseId, print, false);
            } else if (actionList.get(0).equals("removeStudentFromCourse")) {
                regSystem.removeStudentFromCourse(studentId, courseId, print, false);
            } else {
                System.out.println("action is not valid");
            }

        } else {
            System.out.println("there no action to redo");
        }


    }


}
