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
    protected int lastAdded = 0;


    public abstract void add(int id);
    public abstract void remove(int id);

    public int getLastAdded() {
        return lastAdded;
    }

    public int[] getAllTheList() {
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

    @Override
    public void add(int id) {
        StudentNode student = new StudentNode(id);

        if (head == null) {
            head = tail = student;
        } else {
            tail.setNext(student);
            tail = student;
        }

        lastAdded = id;
    }

    @Override
    public void remove(int id) {
        Node current = head, prev = null;

        while (current != null) {
            if (current.getId() == id) {
                if (prev == null) head = current.getNext();
                else prev.setNext(current.getNext());

                if (current == tail) tail = prev;
                break;
            }

            prev = current;
            current = current.getNext();
        }
    }

    public StudentNode findStudentById(int id) {
        Node current = head;
        while (current != null) {
            if (current.getId() == id) return (StudentNode) current;
            current = current.getNext();
        }
        return null;
    }

    public StudentNode getLastStudent() {
        return (StudentNode) tail;
    }

    public void printAllStudents() {
        Node current = head;
        while (current != null) {
            System.out.println("Student ID: " + current.getId());
            current = current.getNext();
        }
    }
}

// Course list implementation
class CoursesList extends LinkedList {

    @Override
    public void add(int id) {
        CourseNode course = new CourseNode(id);

        if (head == null) {
            head = tail = course;
        } else {
            tail.setNext(course);
            tail = course;
        }

        lastAdded = id;
    }

    @Override
    public void remove(int id) {
        Node current = head, prev = null;

        while (current != null) {
            if (current.getId() == id) {
                if (prev == null) head = current.getNext();
                else prev.setNext(current.getNext());

                if (current == tail) tail = prev;
                break;
            }

            prev = current;
            current = current.getNext();
        }
    }

    public CourseNode findCourseById(int id) {
        Node current = head;
        while (current != null) {
            if (current.getId() == id) return (CourseNode) current;
            current = current.getNext();
        }
        return null;
    }

    public CourseNode getLastCourse() {
        return (CourseNode) tail;
    }

    public void printAllCourses() {
        Node current = head;
        while (current != null) {
            System.out.println("Course ID: " + current.getId());
            current = current.getNext();
        }
    }
}