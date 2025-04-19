package RegistrationSystemPackage;
import java.util.ArrayList;

/**
 *
 * @author: Ahmed hassan, hassan , Mostafa
 */
// Generic linked list class for students and courses
abstract class LinkedList {
    protected Node head;
    protected Node tail;
    int itemsCount;

    protected int lastAddedId = 0;
    // TODO: we can replace the variable "lastAddedId" with simply returns the
    // id of the student/course in the tail


    abstract byte add(int id);
    abstract byte remove(int id);

    int getLastAddedId() {
        return tail.getId();
    }

    int[] getAllTheList() {
        // I do not know if using ArrayList is allowed
        // make it fixed size array is better
        // size of array can be known by "itemsCount" variable for the linked list
        ArrayList<Integer> ids = new ArrayList<>();
        Node current = head;
        while (current != null) {
            ids.add(current.getId());
            current = current.getNext();
        }
        return ids.stream().mapToInt(i -> i).toArray();
    }
}

// Student list implementation
class StudentsList extends LinkedList {

    StudentNode head;
    StudentNode tail;

    @Override
    byte add(int id) {
        // returns number of type "byte" for status
        // 1 = successfully added
        // 0 = There is item with given id (already added)


        // TODO: we must to check if id is already exist
        // if exist: return 0;
        // else: add it and return 1;

        StudentNode student = new StudentNode(id);

        if (head == null) {
            head = tail = student;
        } else {
            tail.setNext(student);
            tail = student;
        }

        lastAddedId = id;

        return 1; // temporally until edit the method implementation
    }

    @Override
    byte remove(int id) {
        // returns number of type "byte" for status
        // 1 = successfully removed
        // 0 = There is no item with given id to removed


        StudentNode current = head, prev = null;

        while (current != null) {
            if (current.getId() == id) {

                current.removeAllCoursesOfMe(); // remove all enrollments related first

                if (prev == null) head = current.getNext();
                else prev.setNext(current.getNext());

                if (current == tail) tail = prev;

                return 1; // successfully removed
                //break;
            }

            prev = current;
            current = current.getNext();
        }
        return 0; // There is no item with given id to removed
    }

    StudentNode getStudentNodeById(int id) {
        Node current = head;
        while (current != null) {
            if (current.getId() == id) return (StudentNode) current;
            current = current.getNext();
        }
        return null;
    }

    StudentNode getLastStudentNode() {
        return tail;
    }


//    // not need it, LinkedList's getAllTheList() is good
//    void printAllStudents() {
//        Node current = head;
//        while (current != null) {
//            System.out.println("Student ID: " + current.getId());
//            current = current.getNext();
//        }
//    }
}

// Course list implementation
class CoursesList extends LinkedList {

    CourseNode head;
    CourseNode tail;



    @Override
    byte add(int id) {
        // returns number of type "byte" for status
        // 1 = successfully added
        // 0 = There is item with given id (already added)


        // TODO: we must to check if id is already exist
        // if exist: print a warning that id is already exist
        // else: add it and print that it has added


        CourseNode course = new CourseNode(id);

        if (head == null) {
            head = tail = course;
        } else {
            tail.setNext(course);
            tail = course;
        }

        lastAddedId = id;

        return 1; // temporally until edit the method implementation
    }

    @Override
    byte remove(int id) {
        // returns number of type "byte" for status
        // 1 = successfully removed
        // 0 = There is no item with given id to removed



        CourseNode current = head, prev = null;

        while (current != null) {
            if (current.getId() == id) {

                current.removeAllStudentsOfMe(); // remove all enrollments related first


                if (prev == null) head = current.getNext();
                else prev.setNext(current.getNext());

                if (current == tail) tail = prev;

                return 1; // successfully removed
                //break;
            }

            prev = current;
            current = current.getNext();
        }
        return 0; // There is no item with given id to removed
    }


    CourseNode getCourseNodeById(int id) {
        Node current = head;
        while (current != null) {
            if (current.getId() == id) return (CourseNode) current;
            current = current.getNext();
        }
        return null;
    }

    CourseNode getLastCourseNode() {
        return tail;
    }



//    // not need it, LinkedList's getAllTheList() is good
//    void printAllCourses() {
//        Node current = head;
//        while (current != null) {
//            System.out.println("Course ID: " + current.getId());
//            current = current.getNext();
//        }
//    }
}