package university.system;

import java.util.Scanner;

public class Main {
	
	private static int requestCounter = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentLinkedList studentList = new StudentLinkedList();
        BST studentBST = new BST();
        StudentHashTable studentHashTable = new StudentHashTable();
        ActionStack actionStack = new ActionStack();
        ServiceQueue serviceQueue = new ServiceQueue();
        CampusGraph campusGraph = new CampusGraph();

        boolean running = true;

        while (running) {

            displayMainMenu();

            System.out.print(
                ConsoleUI.CYAN +
                "Enter your choice: " +
                ConsoleUI.RESET
            );

            String choice = scanner.nextLine().trim();

            switch (choice) {

            case "1":
                addStudent(
                    scanner,
                    studentList,
                    studentBST,
                    studentHashTable,
                    actionStack
                );
                break;
                
                case "2":
                    updateStudent(
                        scanner,
                        studentList,
                        actionStack
                    );
                    break;

                case "3":
                    deleteStudent(
                        scanner,
                        studentList,
                        studentBST,
                        studentHashTable,
                        actionStack
                    );
                    break;

                case "4":
                    displayStudents(studentList);
                    break;

                case "5":
                    addServiceRequest(
                        scanner,
                        serviceQueue,
                        studentList,
                        actionStack
                    );
                    break;

                case "6":
                    processNextServiceRequest(
                        serviceQueue,
                        actionStack
                    );
                    break;

                case "7":
                    displayRecentActions(actionStack);
                    break;

                case "8":
                    displayStudentsUsingBST(studentBST);
                    break;

                case "9":
                    searchStudentUsingHashing(
                        scanner,
                        studentHashTable
                    );
                    break;

                case "10":
                    addCampusLocation(
                        scanner,
                        campusGraph
                    );
                    break;

                case "11":
                    removeCampusLocation(
                        scanner,
                        campusGraph
                    );
                    break;

                case "12":
                    addCampusConnection(
                        scanner,
                        campusGraph
                    );
                    break;

                case "13":
                    removeCampusConnection(
                        scanner,
                        campusGraph
                    );
                    break;

                case "14":
                    displayCampusConnections(
                        campusGraph
                    );
                    break;

                case "15":
                    traverseCampusUsingBFS(
                        scanner,
                        campusGraph
                    );
                    break;

                case "16":
                    running = false;

                    ConsoleUI.success(
                        "Thank you for using the system."
                    );
                    break;

                default:
                    ConsoleUI.error(
                        "Invalid menu option. Please try again."
                    );
            }
        }

        scanner.close();
    }


    // ============================================================
    // MAIN MENU
    // ============================================================

    private static void displayMainMenu() {

        ConsoleUI.displayHeader();

        System.out.println(
            ConsoleUI.BLUE +
            ConsoleUI.BOLD +
            "                    MAIN MENU" +
            ConsoleUI.RESET
        );

        System.out.println();

        System.out.println(
            ConsoleUI.CYAN +
            "  STUDENT MANAGEMENT" +
            ConsoleUI.RESET
        );

        System.out.println(
            "  [01] Add Student Record"
        );

        System.out.println(
            "  [02] Update Student Record"
        );

        System.out.println(
            "  [03] Delete Student Record"
        );

        System.out.println(
            "  [04] Display All Records"
        );

        System.out.println();


        System.out.println(
            ConsoleUI.CYAN +
            "  SERVICE MANAGEMENT" +
            ConsoleUI.RESET
        );

        System.out.println(
            "  [05] Add Service Request"
        );

        System.out.println(
            "  [06] Process Next Service Request"
        );

        System.out.println(
            "  [07] View Recent Actions"
        );

        System.out.println();


        System.out.println(
            ConsoleUI.CYAN +
            "  SEARCH & ORGANIZATION" +
            ConsoleUI.RESET
        );

        System.out.println(
            "  [08] Display Students using BST"
        );

        System.out.println(
            "  [09] Search Student using Hashing"
        );

        System.out.println();


        System.out.println(
            ConsoleUI.CYAN +
            "  CAMPUS NETWORK" +
            ConsoleUI.RESET
        );

        System.out.println(
            "  [10] Add Campus Location"
        );

        System.out.println(
            "  [11] Remove Campus Location"
        );

        System.out.println(
            "  [12] Add Campus Connection"
        );

        System.out.println(
            "  [13] Remove Campus Connection"
        );

        System.out.println(
            "  [14] Display Campus Connections"
        );

        System.out.println(
            "  [15] Traverse Campus using BFS"
        );

        System.out.println();


        System.out.println(
            ConsoleUI.RED +
            "  [16] Exit" +
            ConsoleUI.RESET
        );

        System.out.println();

        System.out.println(
            "──────────────────────────────────────────────────────────────"
        );
    }


    // ============================================================
    // ADD STUDENT
    // ============================================================

    private static void addStudent(
            Scanner scanner,
            StudentLinkedList studentList,
            BST studentBST,
            StudentHashTable studentHashTable,
            ActionStack actionStack) {

        ConsoleUI.sectionHeader(
            "ADD STUDENT RECORD"
        );

        System.out.print(
            "Enter Student ID : "
        );

        String id =
            scanner.nextLine().trim();

        if (id.isEmpty()) {

            ConsoleUI.error(
                "Student ID cannot be empty."
            );

            return;
        }


        // Check duplicate Student ID

        if (studentList.searchStudent(id) != null) {

            ConsoleUI.error(
                "Student ID already exists."
            );

            return;
        }


        // Student Name

        System.out.print(
            "Enter Name       : "
        );

        String name =
            scanner.nextLine().trim();

        if (name.isEmpty()) {

            ConsoleUI.error(
                "Name cannot be empty."
            );

            return;
        }


        // Programme

        System.out.print(
            "Enter Programme  : "
        );

        String programme =
            scanner.nextLine().trim();

        if (programme.isEmpty()) {

            ConsoleUI.error(
                "Programme cannot be empty."
            );

            return;
        }


        // Marks

        double marks;

        while (true) {

            System.out.print(
                "Enter Marks      : "
            );

            String marksInput =
                scanner.nextLine().trim();

            try {

                marks =
                    Double.parseDouble(marksInput);

                if (marks < 0 || marks > 100) {

                    ConsoleUI.warning(
                        "Marks must be between 0 and 100."
                    );

                } else {

                    break;
                }

            } catch (NumberFormatException e) {

                ConsoleUI.error(
                    "Please enter a valid number."
                );
            }
        }


        // Create Student Object

        Student student =
            new Student(
                id,
                name,
                programme,
                marks
            );


        // Add to Linked List

        studentList.addStudent(student);

        studentBST.insert(student);

        studentHashTable.insert(student);

        actionStack.push(
            "Added student: " + id
        );
        ConsoleUI.success(
            "Student record added successfully."
        );
    }


    // ============================================================
    // UPDATE STUDENT
    // ============================================================

    private static void updateStudent(
            Scanner scanner,
            StudentLinkedList studentList,
            ActionStack actionStack) {

        ConsoleUI.sectionHeader(
            "UPDATE STUDENT RECORD"
        );

        System.out.print(
            "Enter Student ID: "
        );

        String id =
            scanner.nextLine().trim();


        Student existing =
            studentList.searchStudent(id);


        if (existing == null) {

            ConsoleUI.error(
                "Student record not found."
            );

            return;
        }


        // New Name

        System.out.print(
            "Enter New Name [" +
            existing.getName() +
            "]: "
        );

        String name =
            scanner.nextLine().trim();

        if (name.isEmpty()) {

            name =
                existing.getName();
        }


        // New Programme

        System.out.print(
            "Enter New Programme [" +
            existing.getProgramme() +
            "]: "
        );

        String programme =
            scanner.nextLine().trim();

        if (programme.isEmpty()) {

            programme =
                existing.getProgramme();
        }


        // New Marks

        double marks;

        while (true) {

            System.out.print(
                "Enter New Marks [" +
                existing.getMarks() +
                "]: "
            );

            String input =
                scanner.nextLine().trim();


            // Keep old marks

            if (input.isEmpty()) {

                marks =
                    existing.getMarks();

                break;
            }


            try {

                marks =
                    Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {

                    break;

                } else {

                    ConsoleUI.warning(
                        "Marks must be between 0 and 100."
                    );
                }

            } catch (NumberFormatException e) {

                ConsoleUI.error(
                    "Please enter a valid number."
                );
            }
        }


        // Update Student

        studentList.updateStudent(
            id,
            name,
            programme,
            marks
        );


        ConsoleUI.success(
            "Student record updated successfully."
        );


        // Add action to Stack

        actionStack.push(
            "Updated student: " + id
        );
    }


    // ============================================================
    // DELETE STUDENT
    // ============================================================

    private static void deleteStudent(
            Scanner scanner,
            StudentLinkedList studentList,
            BST studentBST,
            StudentHashTable studentHashTable,
            ActionStack actionStack) {

        ConsoleUI.sectionHeader(
            "DELETE STUDENT RECORD"
        );

        System.out.print(
            "Enter Student ID: "
        );

        String id =
            scanner.nextLine().trim();


        Student student =
            studentList.searchStudent(id);


        if (student == null) {

            ConsoleUI.error(
                "Student record not found."
            );

            return;
        }


        // Display student before deletion

        System.out.println();

        System.out.println(
            "Student to delete:"
        );

        System.out.println(
            student
        );

        System.out.println();


        // Confirmation

        System.out.print(
            "Are you sure you want to delete this record? (Y/N): "
        );

        String confirmation =
            scanner.nextLine().trim();


        if (confirmation.equalsIgnoreCase("Y")) {

            studentList.deleteStudent(id);

            studentBST.delete(id);

            studentHashTable.delete(id);

            ConsoleUI.success(
                "Student record deleted successfully."
            );

            actionStack.push(
                "Deleted student: " + id
            );

        } else {

            ConsoleUI.info(
                "Delete operation cancelled."
            );
        }
    }


    // ============================================================
    // DISPLAY STUDENTS
    // ============================================================

    private static void displayStudents(
            StudentLinkedList studentList) {

        ConsoleUI.sectionHeader(
            "ALL STUDENT RECORDS - LINKED LIST"
        );

        studentList.displayAllStudents();
    }


    // ============================================================
    // ADD SERVICE REQUEST
    // ============================================================

    private static void addServiceRequest(
            Scanner scanner,
            ServiceQueue serviceQueue,
            StudentLinkedList studentList,
            ActionStack actionStack) {

        ConsoleUI.sectionHeader(
            "ADD SERVICE REQUEST - QUEUE"
        );


        // Student ID

        System.out.print(
            "Enter Student ID : "
        );

        String studentId =
            scanner.nextLine().trim();


        if (studentId.isEmpty()) {

            ConsoleUI.error(
                "Student ID cannot be empty."
            );

            return;
        }


        // Check student

        Student student =
            studentList.searchStudent(studentId);


        if (student == null) {

            ConsoleUI.error(
                "Student record not found."
            );

            return;
        }


        // Service Type

        System.out.print(
            "Enter Service Type: "
        );

        String requestType =
            scanner.nextLine().trim();


        if (requestType.isEmpty()) {

            ConsoleUI.error(
                "Service type cannot be empty."
            );

            return;
        }


        // Generate Request ID

        String requestId =
                "REQ-" + String.format("%03d", requestCounter++);


        // Create Service Request

        ServiceRequest request =
            new ServiceRequest(
                requestId,
                studentId,
                requestType
            );


        // Add to Queue

        serviceQueue.enqueue(request);


        ConsoleUI.success(
            "Service request added successfully."
        );


        System.out.println();

        System.out.println(
            ConsoleUI.BLUE +
            request +
            ConsoleUI.RESET
        );


        // Add action to Stack

        actionStack.push(
            "Added service request: " +
            requestId
        );
    }


    // ============================================================
    // PROCESS NEXT SERVICE REQUEST
    // ============================================================

    private static void processNextServiceRequest(
            ServiceQueue serviceQueue,
            ActionStack actionStack) {

        ConsoleUI.sectionHeader(
            "PROCESS NEXT SERVICE REQUEST"
        );


        // Check Queue

        if (serviceQueue.isEmpty()) {

            ConsoleUI.warning(
                "No service requests available."
            );

            return;
        }


        // FIFO - Remove first request

        ServiceRequest request =
            serviceQueue.dequeue();


        System.out.println();

        System.out.println(
            ConsoleUI.BLUE +
            "Processing Request:" +
            ConsoleUI.RESET
        );

        System.out.println(
            request
        );


        ConsoleUI.success(
            "Service request processed successfully."
        );


        // Add action to Stack

        actionStack.push(
            "Processed service request: " +
            request.getRequestId()
        );
    }


    // ============================================================
    // DISPLAY RECENT ACTIONS
    // ============================================================

    private static void displayRecentActions(
            ActionStack actionStack) {

        ConsoleUI.sectionHeader(
            "RECENT ACTIONS - STACK"
        );

        actionStack.displayActions();
    }
    
	 // ============================================================
	 // DISPLAY STUDENTS USING BST
	 // ============================================================
	
	 private static void displayStudentsUsingBST(
	         BST studentBST) {
	
	     ConsoleUI.sectionHeader(
	         "STUDENTS - BINARY SEARCH TREE"
	     );
	
	     if (studentBST.isEmpty()) {
	
	         ConsoleUI.warning(
	             "No students available in BST."
	         );
	
	         return;
	     }
	
	     System.out.println(
	         ConsoleUI.BLUE +
	         "Students sorted by Student ID:" +
	         ConsoleUI.RESET
	     );
	
	     System.out.println();
	
	     studentBST.displayInOrder();
	 }
	 
	// ============================================================
	// SEARCH STUDENT USING HASHING
	// ============================================================

	private static void searchStudentUsingHashing(
	        Scanner scanner,
	        StudentHashTable studentHashTable) {

	    ConsoleUI.sectionHeader(
	        "SEARCH STUDENT - HASHING"
	    );

	    System.out.print(
	        "Enter Student ID: "
	    );

	    String studentId =
	        scanner.nextLine().trim();

	    if (studentId.isEmpty()) {

	        ConsoleUI.error(
	            "Student ID cannot be empty."
	        );

	        return;
	    }

	    Student student =
	        studentHashTable.search(studentId);

	    if (student == null) {

	        ConsoleUI.error(
	            "Student record not found."
	        );

	        return;
	    }

	    System.out.println();

	    System.out.println(
	        ConsoleUI.GREEN +
	        "Student found using Hashing:" +
	        ConsoleUI.RESET
	    );

	    System.out.println();

	    System.out.println(student);
	}
	
	// ============================================================
	// ADD CAMPUS LOCATION
	// ============================================================

	private static void addCampusLocation(
	        Scanner scanner,
	        CampusGraph campusGraph) {

	    ConsoleUI.sectionHeader(
	        "ADD CAMPUS LOCATION"
	    );

	    System.out.print(
	        "Enter Campus Location: "
	    );

	    String location =
	        scanner.nextLine().trim();

	    if (location.isEmpty()) {

	        ConsoleUI.error(
	            "Campus location cannot be empty."
	        );

	        return;
	    }

	    boolean added =
	        campusGraph.addLocation(location);

	    if (added) {

	        ConsoleUI.success(
	            "Campus location added successfully."
	        );

	    } else {

	        ConsoleUI.error(
	            "Campus location already exists."
	        );
	    }
	}
	
	// ============================================================
	// REMOVE CAMPUS LOCATION
	// ============================================================

	private static void removeCampusLocation(
	        Scanner scanner,
	        CampusGraph campusGraph) {

	    ConsoleUI.sectionHeader(
	        "REMOVE CAMPUS LOCATION"
	    );

	    System.out.print(
	        "Enter Campus Location: "
	    );

	    String location =
	        scanner.nextLine().trim();

	    if (location.isEmpty()) {

	        ConsoleUI.error(
	            "Campus location cannot be empty."
	        );

	        return;
	    }

	    boolean removed =
	        campusGraph.removeLocation(location);

	    if (removed) {

	        ConsoleUI.success(
	            "Campus location removed successfully."
	        );

	    } else {

	        ConsoleUI.error(
	            "Campus location not found."
	        );
	    }
	}
	
	// ============================================================
	// ADD CAMPUS CONNECTION
	// ============================================================

	private static void addCampusConnection(
	        Scanner scanner,
	        CampusGraph campusGraph) {

	    ConsoleUI.sectionHeader(
	        "ADD CAMPUS CONNECTION"
	    );

	    System.out.print(
	        "Enter First Location: "
	    );

	    String location1 =
	        scanner.nextLine().trim();

	    if (location1.isEmpty()) {

	        ConsoleUI.error(
	            "First location cannot be empty."
	        );

	        return;
	    }

	    System.out.print(
	        "Enter Second Location: "
	    );

	    String location2 =
	        scanner.nextLine().trim();

	    if (location2.isEmpty()) {

	        ConsoleUI.error(
	            "Second location cannot be empty."
	        );

	        return;
	    }

	    boolean added =
	        campusGraph.addConnection(
	            location1,
	            location2
	        );

	    if (added) {

	        ConsoleUI.success(
	            "Campus connection added successfully."
	        );

	    } else {

	        ConsoleUI.error(
	            "Unable to add campus connection. " +
	            "Check that both locations exist and the connection is not already present."
	        );
	    }
	}
	
	// ============================================================
	// DISPLAY CAMPUS CONNECTIONS
	// ============================================================

	private static void displayCampusConnections(
	        CampusGraph campusGraph) {

	    ConsoleUI.sectionHeader(
	        "CAMPUS CONNECTIONS"
	    );

	    campusGraph.displayConnections();
	}
	
	private static void removeCampusConnection(
	        Scanner scanner,
	        CampusGraph campusGraph) {

	    ConsoleUI.sectionHeader(
	        "REMOVE CAMPUS CONNECTION"
	    );

	    System.out.print(
	        "Enter First Location: "
	    );

	    String location1 =
	        scanner.nextLine().trim();

	    if (location1.isEmpty()) {

	        ConsoleUI.error(
	            "First location cannot be empty."
	        );

	        return;
	    }

	    System.out.print(
	        "Enter Second Location: "
	    );

	    String location2 =
	        scanner.nextLine().trim();

	    if (location2.isEmpty()) {

	        ConsoleUI.error(
	            "Second location cannot be empty."
	        );

	        return;
	    }

	    boolean removed =
	        campusGraph.removeConnection(
	            location1,
	            location2
	        );

	    if (removed) {

	        ConsoleUI.success(
	            "Campus connection removed successfully."
	        );

	    } else {

	        ConsoleUI.error(
	            "Campus connection not found."
	        );
	    }
	}
	
	private static void traverseCampusUsingBFS(
	        Scanner scanner,
	        CampusGraph campusGraph) {

	    ConsoleUI.sectionHeader(
	        "CAMPUS BFS TRAVERSAL"
	    );

	    System.out.print(
	        "Enter Starting Location: "
	    );

	    String startLocation =
	        scanner.nextLine().trim();

	    if (startLocation.isEmpty()) {

	        ConsoleUI.error(
	            "Starting location cannot be empty."
	        );

	        return;
	    }

	    campusGraph.bfs(startLocation);
	}
}