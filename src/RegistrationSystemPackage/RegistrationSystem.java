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
            throw new Exception("Check Correct min and max arguments values during creating Registration System.");
        }
        
        this.minCoursesForStudent = minCoursesForStudent;
        this.maxCoursesForStudent = maxCoursesForStudent;
        // this.minStudentsForCourse = minStudentsForCourse; // Not needed in system
        this.maxStudentsForCourse = maxStudentsForCourse;
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
            } else if (status == -1){
                System.out.println("There is no id with negative value.");
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
            } else if (status == -1){
                System.out.println("There is no id with negative value.");
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
            } else if (status == -1){
                System.out.println("There is no id with negative value.");
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
            } else if (status == -1){
                System.out.println("There is no id with negative value.");
            } else {
                System.out.println("Code Error"); // Must not happen never during code testing
            }
        }
    }


    // --- last student / course added ---
    public int getLastStudentAdded(){
        // returns -1 if there is no any student in the system

        return studentsList.getLastAddedId();
    }
    public int getLastCourseAdded(){
        // returns -1 if there is no any course in the system

        return coursesList.getLastAddedId();
    }
    public void displayLastStudentAdded(){
        int id = getLastStudentAdded();
        if (id != -1){
            System.out.println("The id of last student added to system is: "+id);
        } else {
            System.out.println("There is no student in the system currently");
        }
    }
    public void displayLastCourseAdded(){
        int id = getLastCourseAdded();
        if (id != -1){
            System.out.println("The id of last course added to system is: "+id);
        } else {
            System.out.println("There is no course in the system currently");
        }
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
            System.out.println("-- The list of all students in the system are: --");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Student's id: "+lst[i]);
            }
            System.out.println("-- Total of "+lst.length+" students. --");
        }
    }
    public void displayAllCoursesList(){
        int[] lst = getAllCoursesList();

        if (lst.length == 0) {
            System.out.println("There are no courses in the system.");
        } else if (lst.length == 1) {
            System.out.println("There is an one course in system with id " + lst[0]);
        } else {
            System.out.println("-- The list of all courses in the system are: --");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Course's id: "+lst[i]);
            }
            System.out.println("-- Total of "+lst.length+" courses. --");
        }
    }


    public void addStudentToCourse(int studentId, int courseId){
        // sparse table TODO
        // Remember to check maxCoursesForStudent, maxStudentsForCourse before
        // Remember to increase StudentNode's coursesCount and StudentNode's coursesCount
        StudentNode student = studentsList.getStudentNodeById(studentId);
        CourseNode course = coursesList.getCourseNodeById(courseId);
        if (student == null || course == null) return;
        // Create the link (Cell)
        Cell cell = new Cell(studentId, courseId);
        // Add to student's list
        cell.set_next_course(student.firstCell);
        student.firstCell = cell;
        student.coursesCount++;
        // Add to course's list
        cell.set_next_student(course.firstCell);
        course.firstCell = cell;
        course.studentsCount++;
    }
    public void removeStudentFromCourse(int studentId, int courseId) {
// sparse table TODO
// Remember to decrease StudentNode's coursesCount and StudentNode's coursesCount
        StudentNode student = studentsList.getStudentNodeById(studentId);
        CourseNode course = coursesList.getCourseNodeById(courseId);
        if (student == null || course == null) return;
// Remove from student's list
        Cell prev = null, curr = student.firstCell;
        while (curr != null) {
            if (curr.getCourse_ID() == courseId) {
                if (prev == null) student.firstCell = curr.get_next_course();
                else prev.set_next_course(curr.get_next_course());
                student.coursesCount--;
                break;
            }
            prev = curr;
            curr = curr.get_next_course();
        }
// Remove from course's list
        prev = null;
        curr = course.firstCell;
        while (curr != null) {
            if (curr.getStudent_ID() == studentId) {
                if (prev == null) course.firstCell = curr.get_next_student();
                else prev.set_next_student(curr.get_next_student());
                course.studentsCount--;
                break;
            }
            prev = curr;
            curr = curr.get_next_student();
        }
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
            System.out.println("-- The list of all courses of this student are: --");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Course's id: "+lst[i]);
            }
            System.out.println("-- Total of "+lst.length+" courses. --");
        }
    }
    public void displayStudentsOfCourse(int courseId){
        int[] lst = getStudentsOfCourse(courseId);

        if (lst.length == 0) {
            System.out.println("There is no students for this course.");
        } else if (lst.length == 1) {
            System.out.println("There is an one student for this course, student id is: " + lst[0]);
        } else {
            System.out.println("-- The list of all students of this course are: --");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Student's id: "+lst[i]);
            }
            System.out.println("-- Total of "+lst.length+" students. --");
        }
    }



    // --- Check min and max values ----
    public boolean isFullCourse(int courseId) throws Exception {
        // return .getCountOfStudents() >= maxStudentsForCourse;
        CourseNode n = coursesList.getCourseNodeById(courseId);
        if (n == null){
            throw new Exception("Not found course.");
        }
        return n.getCountOfStudents() >= maxStudentsForCourse;
    }
    public boolean isNormalStudent(int studentId) throws Exception {
        StudentNode n = studentsList.getStudentNodeById(studentId);
        if (n == null){
            throw new Exception("Not found student.");
        }
        int count = n.getCountOfCourses();

        return count >= minCoursesForStudent && count <= maxCoursesForStudent;
    }
    public void displayIsFullCourse(int courseId){
        try {
            boolean b = isFullCourse(courseId);
            if (b) {
                System.out.println("The course with ID " + courseId + " is full.");
            } else {
                System.out.println("The course with ID " + courseId + " is not full.");
            }


        } catch (Exception e) {
            System.out.println("There is no found course with this id.");
        }
    }
    public void displayIsNormalStudent(int studentId){
        try {
            boolean b = isNormalStudent(studentId);
            if (b) {
                System.out.println("The student with id " + studentId + " is normal student.");
            } else {
                System.out.println("The student with ID " + studentId + " is not normal student.");
            }


        } catch (Exception e) {
            System.out.println("There is no found student with this id.");
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
