package university.system;

public class BST {

    // ============================================================
    // NODE CLASS
    // ============================================================

    private class Node {

        Student student;

        Node left;
        Node right;


        Node(Student student) {

            this.student = student;
            this.left = null;
            this.right = null;
        }
    }


    // Root node of the BST

    private Node root;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public BST() {

        root = null;
    }


    // ============================================================
    // INSERT STUDENT
    // ============================================================

    public void insert(Student student) {

        if (student == null) {

            return;
        }

        root =
            insertRecursive(
                root,
                student
            );
    }


    // Recursive Insert

    private Node insertRecursive(
            Node current,
            Student student) {

        // Empty position found

        if (current == null) {

            return new Node(student);
        }


        // Compare Student IDs

        int comparison =
            student.getStudentId().compareTo(
                current.student.getStudentId()
            );


        // Smaller ID → Left

        if (comparison < 0) {

            current.left =
                insertRecursive(
                    current.left,
                    student
                );
        }


        // Larger ID → Right

        else if (comparison > 0) {

            current.right =
                insertRecursive(
                    current.right,
                    student
                );
        }


        // Same ID → Do not insert duplicate

        return current;
    }


    // ============================================================
    // SEARCH STUDENT
    // ============================================================

    public Student search(String studentId) {

        Node current = root;


        while (current != null) {

            int comparison =
                studentId.compareTo(
                    current.student.getStudentId()
                );


            // Student found

            if (comparison == 0) {

                return current.student;
            }


            // Search left

            else if (comparison < 0) {

                current = current.left;
            }


            // Search right

            else {

                current = current.right;
            }
        }


        // Student not found

        return null;
    }
    
	 // ============================================================
	 // DELETE STUDENT
	 // ============================================================
	
	 public boolean delete(String studentId) {
	
	     if (studentId == null || studentId.isEmpty()) {
	         return false;
	     }
	
	     if (search(studentId) == null) {
	         return false;
	     }
	
	     root = deleteRecursive(root, studentId);
	
	     return true;
	 }
	
	
	 // Recursive Delete
	 private Node deleteRecursive(
	         Node current,
	         String studentId) {
	
	     if (current == null) {
	         return null;
	     }
	
	     int comparison =
	         studentId.compareTo(
	             current.student.getStudentId()
	         );
	
	
	     // Student ID is smaller → Search Left
	     if (comparison < 0) {
	
	         current.left =
	             deleteRecursive(
	                 current.left,
	                 studentId
	             );
	     }
	
	
	     // Student ID is larger → Search Right
	     else if (comparison > 0) {
	
	         current.right =
	             deleteRecursive(
	                 current.right,
	                 studentId
	             );
	     }
	
	
	     // Student Found
	     else {
	
	         // Case 1: No children
	         if (current.left == null &&
	             current.right == null) {
	
	             return null;
	         }
	
	
	         // Case 2: Only Right Child
	         if (current.left == null) {
	
	             return current.right;
	         }
	
	
	         // Case 3: Only Left Child
	         if (current.right == null) {
	
	             return current.left;
	         }
	
	
	         // Case 4: Two Children
	         Node successor =
	             findMin(current.right);
	
	         current.student =
	             successor.student;
	
	         current.right =
	             deleteRecursive(
	                 current.right,
	                 successor.student.getStudentId()
	             );
	     }
	
	     return current;
	 }
	
	
	 // Find the smallest node
	 // in the right subtree
	 private Node findMin(Node current) {
	
	     while (current.left != null) {
	         current = current.left;
	     }
	
	     return current;
	 }
    
	
    // ============================================================
    // DISPLAY STUDENTS - INORDER
    // ============================================================

    public void displayInOrder() {

        if (root == null) {

            ConsoleUI.warning(
                "BST is empty."
            );

            return;
        }


        System.out.println();

        inOrder(root);
    }


    // Recursive Inorder Traversal

    private void inOrder(Node current) {

        if (current == null) {

            return;
        }


        // Visit Left Subtree

        inOrder(current.left);


        // Visit Current Node

        System.out.println(
            current.student
        );


        // Visit Right Subtree

        inOrder(current.right);
    }


    // ============================================================
    // CHECK WHETHER BST IS EMPTY
    // ============================================================

    public boolean isEmpty() {

        return root == null;
    }


    // ============================================================
    // CLEAR BST
    // ============================================================

    public void clear() {

        root = null;
    }
}