package university.system;

public class StudentLinkedList {

    // Node class for the Linked List
    private static class Node {

        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    // First node of the list
    private Node head;

    // Number of students
    private int size;

    // Constructor
    public StudentLinkedList() {
        head = null;
        size = 0;
    }

    // ==========================================
    // Add Student
    // ==========================================

    public boolean addStudent(Student student) {

        // Check duplicate Student ID
        if (searchStudent(student.getStudentId()) != null) {
            return false;
        }

        Node newNode = new Node(student);

        // If list is empty
        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        return true;
    }

    // ==========================================
    // Search Student
    // ==========================================

    public Student searchStudent(String studentId) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // ==========================================
    // Update Student
    // ==========================================

    public boolean updateStudent(
            String studentId,
            String name,
            String programme,
            double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }

    // ==========================================
    // Delete Student
    // ==========================================

    public boolean deleteStudent(String studentId) {

        if (head == null) {
            return false;
        }

        // If the first node needs to be deleted
        if (head.student.getStudentId().equalsIgnoreCase(studentId)) {

            head = head.next;
            size--;

            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                current.next = current.next.next;
                size--;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // ==========================================
    // Display All Students
    // ==========================================

    public void displayAllStudents() {

        if (head == null) {

            ConsoleUI.warning("No student records available.");

            return;
        }

        Node current = head;

        System.out.println();

        System.out.println(
            ConsoleUI.CYAN +
            "──────────────────────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        while (current != null) {

            System.out.println(current.student);

            current = current.next;
        }

        System.out.println(
            ConsoleUI.CYAN +
            "──────────────────────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.BLUE +
            "Total Students: " +
            size +
            ConsoleUI.RESET
        );
    }

    // ==========================================
    // Get Number of Students
    // ==========================================

    public int getSize() {
        return size;
    }

    // ==========================================
    // Check Empty
    // ==========================================

    public boolean isEmpty() {
        return head == null;
    }
}
