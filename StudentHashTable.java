package university.system;

public class StudentHashTable {

    // ============================================================
    // HASH TABLE SETTINGS
    // ============================================================

    private static final int TABLE_SIZE = 31;

    private Student[] table;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public StudentHashTable() {

        table = new Student[TABLE_SIZE];
    }


    // ============================================================
    // HASH FUNCTION
    // ============================================================

    private int hash(String studentId) {

        int hashValue = 0;

        for (int i = 0; i < studentId.length(); i++) {

            hashValue =
                (hashValue * 31 +
                 studentId.charAt(i)) % TABLE_SIZE;
        }

        return hashValue;
    }


    // ============================================================
    // INSERT STUDENT
    // ============================================================

    public void insert(Student student) {

        if (student == null) {
            return;
        }

        String studentId =
            student.getStudentId();

        int index =
            hash(studentId);

        int originalIndex = index;


        // Linear Probing for collision handling

        while (table[index] != null) {

            if (table[index]
                    .getStudentId()
                    .equals(studentId)) {

                // Update existing student

                table[index] = student;
                return;
            }

            index =
                (index + 1) % TABLE_SIZE;


            // Table is full

            if (index == originalIndex) {

                ConsoleUI.error(
                    "Hash table is full."
                );

                return;
            }
        }


        table[index] = student;
    }


    // ============================================================
    // SEARCH STUDENT
    // ============================================================

    public Student search(String studentId) {

        if (studentId == null ||
            studentId.isEmpty()) {

            return null;
        }

        int index =
            hash(studentId);

        int originalIndex = index;


        while (table[index] != null) {

            if (table[index]
                    .getStudentId()
                    .equals(studentId)) {

                return table[index];
            }

            index =
                (index + 1) % TABLE_SIZE;


            if (index == originalIndex) {

                break;
            }
        }


        return null;
    }


    // ============================================================
    // DELETE STUDENT
    // ============================================================

    public boolean delete(String studentId) {

        if (studentId == null ||
            studentId.isEmpty()) {

            return false;
        }

        int index = hash(studentId);
        int originalIndex = index;

        while (table[index] != null) {

            if (table[index]
                    .getStudentId()
                    .equals(studentId)) {

                // Remove the student
                table[index] = null;

                // Reinsert following students
                // to preserve the probing chain
                index = (index + 1) % TABLE_SIZE;

                while (table[index] != null) {

                    Student studentToRehash =
                        table[index];

                    table[index] = null;

                    insert(studentToRehash);

                    index =
                        (index + 1) % TABLE_SIZE;
                }

                return true;
            }

            index =
                (index + 1) % TABLE_SIZE;

            if (index == originalIndex) {
                break;
            }
        }

        return false;
    }

    // ============================================================
    // DISPLAY HASH TABLE
    // ============================================================

    public void displayTable() {

        System.out.println();

        System.out.println(
            "Hash Table Contents:"
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        boolean hasStudents = false;


        for (int i = 0; i < TABLE_SIZE; i++) {

            if (table[i] != null) {

                hasStudents = true;

                System.out.println(
                    "Index [" +
                    i +
                    "] → " +
                    table[i]
                );
            }
        }


        if (!hasStudents) {

            ConsoleUI.warning(
                "Hash table is empty."
            );
        }


        System.out.println(
            "------------------------------------------------------------"
        );
    }


    // ============================================================
    // CHECK EMPTY
    // ============================================================

    public boolean isEmpty() {

        for (Student student : table) {

            if (student != null) {

                return false;
            }
        }

        return true;
    }
}