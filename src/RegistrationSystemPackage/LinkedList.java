package RegistrationSystemPackage;

import static RegistrationSystemPackage.util.sort;

/**
 *
 * @author: Ahmed Hassan, Hassan, Mostafa
 */

// Generic linked list class for students and courses
abstract class LinkedList {
    protected Node head;
    protected Node tail;
    int itemsCount;

    abstract byte add(int id);
    abstract byte remove(int id);

    int getLastAddedId() {
        // returns -1 if there is no added student

        return tail != null ? tail.getId() : -1;
    }

    int[] getAllTheList() {
        int[] ids = new int[itemsCount]; // مصفوفة بحجم ثابت
        Node current = head;
        int i = 0;
        while (current != null && i < itemsCount) {
            ids[i++] = current.getId();
            current = current.getNext();
        }
        return ids;
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
        // -1 = negative id given (invalid id)

        if (id < 0) {
            return -1;
        }

        if (getStudentNodeById(id) != null) {
            return 0; // الطالب موجود بالفعل
        }

        StudentNode student = new StudentNode(id);

        if (head == null) {
            head = tail = student;
        } else {
            tail.setNext(student);
            tail = student;
        }

        itemsCount++;

        return 1; // تم الإضافة بنجاح
    }

    @Override
    byte remove(int id) {
        // returns number of type "byte" for status
        // 1 = successfully removed
        // 0 = There is no item with given id to removed
        // -1 = negative id given (invalid id)

        if (id < 0) {
            return -1;
        }

        StudentNode current = head;
        StudentNode prev = null;

        while (current != null) {
            if (current.getId() == id) {
                current.removeAllCoursesOfMe(); // remove all enrollments related first

                if (prev == null) head = current.getNext();
                else prev.setNext(current.getNext());

                if (current == tail) tail = prev;

                itemsCount--;
                return 1;
            }

            prev = current;
            current = current.getNext();
        }
        return 0;
    }

    StudentNode getStudentNodeById(int id) {

        if (id < 0) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.getId() == id) return (StudentNode) current;
            current = current.getNext();
        }
        return null;
    }
    @Override
    int[] getAllTheList() {
        // returns it sorted

        int[] ids = new int[itemsCount];
        StudentNode current = head;        
        int i = 0;
        while (current != null && i < itemsCount) {
            ids[i++] = current.getId();
            current = current.getNext();   
        }
        sort(ids);
        return ids;
    }
    @Override
int getLastAddedId() {
    return (tail != null) ? tail.getId() : -1;
}
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
        // -1 = negative id given (invalid id)

        if (id < 0) {
            return -1;
        }

        if (getCourseNodeById(id) != null) {
            return 0;
        }

        CourseNode course = new CourseNode(id);

        if (head == null) {
            head = tail = course;
        } else {
            tail.setNext(course);
            tail = course;
        }

        itemsCount++;

        return 1;
    }

    @Override
    byte remove(int id) {
        // returns number of type "byte" for status
        // 1 = successfully removed
        // 0 = There is no item with given id to removed
        // -1 = negative id given (invalid id)

        if (id < 0) {
            return -1;
        }

        CourseNode current = head;
        CourseNode prev = null;

        while (current != null) {
            if (current.getId() == id) {
                current.removeAllStudentsOfMe(); // remove all enrollments related first

                if (prev == null) head = current.getNext();
                else prev.setNext(current.getNext());

                if (current == tail) tail = prev;

                itemsCount--;
                return 1;
            }

            prev = current;
            current = current.getNext();
        }
        return 0;
    }

    CourseNode getCourseNodeById(int id) {

        if (id < 0) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.getId() == id) return (CourseNode) current;
            current = current.getNext();
        }
        return null;
    }
    @Override
    int[] getAllTheList() {
        int[] ids = new int[itemsCount];
        CourseNode current = head;
        int i = 0;
        while (current != null && i < itemsCount) {
            ids[i++] = current.getId();
            current = current.getNext();
        }
        sort(ids);
        return ids;
    }
    @Override
int getLastAddedId() {
    return (tail != null) ? tail.getId() : -1;
}
}
