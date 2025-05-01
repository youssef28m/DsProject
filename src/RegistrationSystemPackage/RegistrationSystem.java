package RegistrationSystemPackage;

import static RegistrationSystemPackage.util.sort;

/**
 *
 * @author: youssef Sherif, Amr, Ahmed sobhy
 */
public class RegistrationSystem {

    
    private final StudentsList studentsList = new StudentsList();
    private final CoursesList coursesList = new CoursesList();

    private final History history = new History(this);

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
                System.out.println("The student with the id " + id + " is already added.");
            } else if (status == -1){
                System.out.println("Can't add id with negative value.");
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
                System.out.println("The course with the id " + id + " is already added.");
            } else if (status == -1){
                System.out.println("Can't add id with negative value.");
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


    // sparse table Task
    public byte addStudentToCourse(int studentId, int courseId) {
        return addStudentToCourse(studentId, courseId, true, true);
    }
    public byte addStudentToCourse(int studentId, int courseId, boolean print, boolean h) {
        // Add enrollment method

        // returns number of type "byte" for status
        // 1 = has added successfully
        // -1 = there is no student with this id
        // -2 = there is no course with this id
        // -3 = this student has the max number of courses
        // -4 = this course has the max number of students
        if (h) {
            history.addActionToHistory("addStudentToCourse " + studentId + " " + courseId + " " + print);
        }

        StudentNode studentNode = studentsList.getStudentNodeById(studentId);
        CourseNode courseNode = coursesList.getCourseNodeById(courseId);

        // Check exist of student and course in system
        if (studentNode == null) {
            if (print) System.out.println("Cannot add the student to course, The student with id " + studentId + " does not exist in system.");
            return -1;
        }
        if (courseNode == null) {
            if (print) System.out.println("Cannot add the student to course, The course with id " + courseId + " does not exist in system.");
            return -2;
        }
        for (Cell c = studentNode.firstCell; c != null; c = c.get_next_course()) {
            if (c.getCourse_ID() == courseId) {
                if (print) {
                    System.out.println("Cannot enroll: Student " 
                        + studentId + " is already in course " + courseId);
                }
                return -5;   // duplicate to check enrollment
            }
        }

        // Check capacity of student and course
        if (isFullStudent(studentNode)) {
            if (print) System.out.println("Cannot add the student to course, The student has the max number of courses.");
            return -3;
        }
        if (isFullCourse(courseNode)) {
            if (print) System.out.println("Cannot add the student to course, The course has the max number of students.");
            return -4;
        }


        // Create the enrollment node (Cell)
        Cell cell = new Cell(studentNode, courseNode);

        // Add to student's list
        cell.set_next_course(studentNode.firstCell);
        studentNode.firstCell = cell;
        studentNode.coursesCount++;

        // Add to course's list
        cell.set_next_student(courseNode.firstCell);
        courseNode.firstCell = cell;
        courseNode.studentsCount++;

        if (print) System.out.println("The student with id " + studentId + " has been added to the course with id "+courseId+" successfully.");
        return 1;
    }
    public byte removeStudentFromCourse(int studentId, int courseId) {
        return removeStudentFromCourse(studentId, courseId, true, true);
    }
    public byte removeStudentFromCourse(int studentId, int courseId, boolean print, boolean h) {
        // remove enrollment method

        // returns number of type "byte" for status
        // 1 = has removed successfully
        // 0 = there is no enrollment with this student and this course
        // -1 = there is no student with this id
        // -2 = there is no course with this id

        // Remember to decrease StudentNode's coursesCount and StudentNode's coursesCount
        if (h) {
            history.addActionToHistory("removeStudentToCourse " + studentId + " " + courseId + " " + print);
        }

        StudentNode studentNode = studentsList.getStudentNodeById(studentId);
        CourseNode courseNode = coursesList.getCourseNodeById(courseId);


        // Check exist of student and course in system
        if (studentNode == null) {
            if (print) System.out.println("Cannot remove the student from course, The student with id " + studentId + " does not exist in system.");
            return -1;
        }
        if (courseNode == null) {
            if (print) System.out.println("Cannot remove the student from course, The course with id " + courseId + " does not exist in system.");
            return -2;
        }

        // TODO: improve remove by use cell's prev pointers instead of two seperated loops

        // Remove from student's list
        Cell prev = null, curr = studentNode.firstCell;
        boolean found = false;
        while (curr != null) {
            if (curr.getCourse_ID() == courseId) {
                if (prev == null) studentNode.firstCell = curr.get_next_course();
                else prev.set_next_course(curr.get_next_course());
                studentNode.coursesCount--;
                found = true;
                break;
            }
            prev = curr;
            curr = curr.get_next_course();
        }
        if (!found) {
            if (print) System.out.println("There is no enrollment for this student and this course in the system.");
            return 0;
        }

        // Remove from course's list
        prev = null;
        curr = courseNode.firstCell;
        while (curr != null) {
            if (curr.getStudent_ID() == studentId) {
                if (prev == null) courseNode.firstCell = curr.get_next_student();
                else prev.set_next_student(curr.get_next_student());
                courseNode.studentsCount--;
                break;
            }
            prev = curr;
            curr = curr.get_next_student();
        }

        if (print) System.out.println("The student with id " + studentId + " has been removed from the course with id "+courseId+" successfully.");
        return 1;
    }


    public int[] getCoursesOfStudent(int studentId){
        // returns:
        //      if not exist the student : null
        //      if there is no courses : empty array
        //      no problem : normal array

        StudentNode studentNode = studentsList.getStudentNodeById(studentId);
        if (studentNode == null) {
            return null;
        }

        Cell current = studentNode.firstCell;
        if (current == null) {
            return new int[0]; // returns empty array
        }

        int[] arr = new int[studentNode.coursesCount];
        int counter = 0;
        while (current != null) {
            arr[counter] = current.getCourse_ID();
            counter++;
            current = current.get_next_course();
        }
        sort(arr);
        return arr;
    }

    public int[] getStudentsOfCourse(int courseId){
        // returns:
        //      if not exist the student : null
        //      if there is no courses : empty array
        //      no problem : normal array

        CourseNode courseNode = coursesList.getCourseNodeById(courseId);

        if (courseNode == null) {
            return null;
        }

        Cell current = courseNode.firstCell;
        if (current == null) {
            return new int[0];
        }

        int[] arr = new int[courseNode.studentsCount];
        int counter = 0;
        while (current != null) {
            arr[counter] = current.getStudent_ID();
            counter++;
            current = current.get_next_student();
        }
        sort(arr);
        return arr;
    }
    public void displayCoursesOfStudent(int studentId){
        int[] lst = getCoursesOfStudent(studentId);

        if (lst == null) {
            System.out.println("Student with id "+studentId+" not found.");
        } else if (lst.length == 0) {
            System.out.println("There is no courses for this student with id "+studentId);
        } else if (lst.length == 1) {
            System.out.println("There is an one course for this student with id "+studentId+", course id is: " + lst[0]);
        } else {
            System.out.println("-- The list of all courses of this student with id "+studentId+" are: --");
            for (int i = 0; i < lst.length; i++) {
                System.out.println("Course's id: "+lst[i]);
            }
            System.out.println("-- Total of "+lst.length+" courses. --");
        }
    }
    public void displayStudentsOfCourse(int courseId){
        int[] lst = getStudentsOfCourse(courseId);

        if (lst == null) {
            System.out.println("Course with id "+courseId+"  not found.");
        } else if (lst.length == 0) {
            System.out.println("There is no students for this course with id "+courseId);
        } else if (lst.length == 1) {
            System.out.println("There is an one student for this course with id "+courseId+", student id is: " + lst[0]);
        } else {
            System.out.println("-- The list of all students of this course with id "+courseId+" are: --");
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




    private boolean isFullStudent(StudentNode studentNode) {
        // made this method to use in addStudentToList() to check

        return studentNode.getCountOfCourses() >= maxCoursesForStudent;
    }
    private boolean isFullCourse(CourseNode courseNode) {
        // made this method to use in addStudentToList() to check

        return courseNode.getCountOfStudents() >= maxStudentsForCourse;
    }





    // --- history ----
    public void undo(){
        history.undo();
    }
    public void redo(){
        history.redo();
    }


}
