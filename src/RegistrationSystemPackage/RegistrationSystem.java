package RegistrationSystemPackage;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
public class RegistrationSystem {

    
    private final StudentsList studentsList = new StudentsList();
    private final CoursesList coursesList = new CoursesList();

    private final History history = new History();

    private final int minCoursesForStudent;
    private final int maxCoursesForStudent;
    // private final int minStudentsForCourse; // Not needed in system
    private final int maxStudentsForCourse;

    public RegistrationSystem(int minCoursesForStudent, int maxCoursesForStudent, int maxStudentsForCourse) throws java.lang.Exception {
        if (minCoursesForStudent < 0 || maxCoursesForStudent < minCoursesForStudent || maxStudentsForCourse < 0){
            throw Exception("Check Correct min and max arguments values during creating Registration System.");
        }
        
        this.minCoursesForStudent = minCoursesForStudent;
        this.maxCoursesForStudent = maxCoursesForStudent;
        // this.minStudentsForCourse = minStudentsForCourse;
        this.maxStudentsForCourse = maxStudentsForCourse;
    }

    private Exception Exception(String message) {
        throw new UnsupportedOperationException(message);
    }


    // --- Add student or course ---
    public void addStudent(int id){
        addStudent(id, true);
    }
    public void addStudent(int id, boolean print){
        byte status = studentsList.add(id);
        if (print){
            if (status == 1){
                System.out.println("The student with the id " + id + " has added successfully.");
            } else if (status == 0){
                System.out.println("There is no student with the id " + id + " is already added.");
            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }
        }
    }
    public void addCourse(int id){
        addCourse(id, true);
    }
    public void addCourse(int id, boolean print){
        byte status = coursesList.add(id);
        if (print){
            if (status == 1){
                System.out.println("The course with the id " + id + " has added successfully.");
            } else if (status == 0){
                System.out.println("There is no course with the id " + id + " is already added.");
            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }
        }
    }



    // --- remove student or course ---
    public void removeStudent(int id) {
        removeStudent(id, true);
    }
    public void removeStudent(int id, boolean print){
        byte status = studentsList.remove(id);
        if (print){
            if (status == 1){
                System.out.println("The student with the id " + id + " has been removed successfully.");
            } else if (status == 0){
                System.out.println("There is no student with the id " + id + " to be removed (already not exist).");
            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }
        }
    }
    public void removeCourse(int id) {
        removeCourse(id, true);
    }
    public void removeCourse(int id, boolean print){
        byte status = coursesList.remove(id);
        if (print){
            if (status == 1){
                System.out.println("The course with the id " + id + " has been removed successfully.");
            } else if (status == 0){
                System.out.println("There is no course with the id " + id + " to be removed (already not exist).");
            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }
        }
    }


    // --- last student / course added ---
    public int getLastStudentAdded(){
        return studentsList.getLastAddedId();
    }
    public int getLastCourseAdded(){
        return coursesList.getLastAddedId();
    }
    public void displayLastStudentAdded(){
        System.out.println("The id of last student added to system is: "+getLastStudentAdded());
    }
    public void displayLastCourseAdded(){
        System.out.println("The id of last course added to system is: "+getLastCourseAdded());
    }

    
    // --- get all the students / courses ---
    public int[] getAllStudentsList(){
        return studentsList.getAllTheList();
    }
    public int[] getAllCoursesList(){
        return coursesList.getAllTheList();
    }
    public void displayAllStudentsList(){
        int[] lst = getAllStudentsList();

        if (lst.length == 0) {
            System.out.println("There are no students in the system.");
        } else if (lst.length == 1) {
            System.out.println("There is an one student in system with id " + lst[0]);
        } else {
            System.out.println("The list of all students in the system are:");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Student's id: "+lst[i]);
            }
            System.out.println("Total of "+lst.length+" students.");
        }
    }
    public void displayAllCoursesList(){
        int[] lst = getAllCoursesList();

        if (lst.length == 0) {
            System.out.println("There are no courses in the system.");
        } else if (lst.length == 1) {
            System.out.println("There is an one course in system with id " + lst[0]);
        } else {
            System.out.println("The list of all courses in the system are:");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Course's id: "+lst[i]);
            }
            System.out.println("Total of "+lst.length+" courses.");
        }
    }
    
    
    public void addStudentToCourse(int studentId, int courseId){
        // sparse table TODO
        // Remember to check maxCoursesForStudent, maxStudentsForCourse before
        // Remember to increase StudentNode's coursesCount and StudentNode's coursesCount
    }
    public void removeStudentFromCourse(int studentId, int courseId){
        // sparse table TODO
        // Remember to decrease StudentNode's coursesCount and StudentNode's coursesCount
    }


    
    public int[] getCoursesOfStudent(int studentId){
        // sparse table TODO
        return new int[0]; // temporally until write code to ignore error
    }
    public int[] getStudentsOfCourse(int courseId){
        // sparse table TODO
        return new int[0]; // temporally until write code to ignore error
    }
    public void displayCoursesOfStudent(int studentId){
        int[] lst = getCoursesOfStudent(studentId);

        if (lst.length == 0) {
            System.out.println("There is no courses for this student.");
        } else if (lst.length == 1) {
            System.out.println("There is an one course for this student, course id is: " + lst[0]);
        } else {
            System.out.println("The list of all courses of this student are:");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Course's id: "+lst[i]);
            }
            System.out.println("Total of "+lst.length+" courses.");
        }
    }
    public void displayStudentsOfCourse(int courseId){
        int[] lst = getStudentsOfCourse(courseId);

        if (lst.length == 0) {
            System.out.println("There is no students for this course.");
        } else if (lst.length == 1) {
            System.out.println("There is an one student for this course, student id is: " + lst[0]);
        } else {
            System.out.println("The list of all students of this course are:");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Student's id: "+lst[i]);
            }
            System.out.println("Total of "+lst.length+" students.");
        }
    }



    // --- Check min and max values ----
    public boolean isFullCourse(int courseId){
        return coursesList.getCourseNodeById(courseId).getCountOfStudents() >= maxStudentsForCourse;
    }
    public boolean isNormalStudent(int studentId){
        int count = studentsList.getStudentNodeById(studentId).getCountOfCourses();
        return count >= minCoursesForStudent && count <= maxCoursesForStudent;
    }
    public void displayIsFullCourse(int courseId){
        if (coursesList.getCourseNodeById(courseId).getCountOfStudents() >= maxStudentsForCourse)
            System.out.println("The course with ID " + courseId + " is full.");
        else
            System.out.println("The course with ID " + courseId + " is not full.");
    }
    public void displayIsNormalStudent(int studentId){
        int count = studentsList.getStudentNodeById(studentId).getCountOfCourses();
        if (!(count >= minCoursesForStudent)) {
            System.out.println("The student with ID " + studentId + " is not normal student (has less courses).");
        } else if (!(count <= maxCoursesForStudent)) {
            System.out.println("The student with ID " + studentId + " is not normal student (has more courses).");
        } else {
            System.out.println("The student with id " + studentId + " is normal student.");
        }
    }


    // --- history ----
    public void undo(){
        history.undo();
    }
    public void redo(){
        history.redo();
    }


}
