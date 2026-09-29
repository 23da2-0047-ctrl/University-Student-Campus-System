package university.system;

public class Student {

    private String studentId;
    private String name;
    private String programme;
    private double marks;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public Student(
            String studentId,
            String name,
            String programme,
            double marks) {

        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }


    // ============================================================
    // GET STUDENT ID
    // ============================================================

    public String getStudentId() {

        return studentId;
    }


    // ============================================================
    // GET NAME
    // ============================================================

    public String getName() {

        return name;
    }


    // ============================================================
    // GET PROGRAMME
    // ============================================================

    public String getProgramme() {

        return programme;
    }


    // ============================================================
    // GET MARKS
    // ============================================================

    public double getMarks() {

        return marks;
    }


    // ============================================================
    // UPDATE NAME
    // ============================================================

    public void setName(String name) {

        this.name = name;
    }


    // ============================================================
    // UPDATE PROGRAMME
    // ============================================================

    public void setProgramme(String programme) {

        this.programme = programme;
    }


    // ============================================================
    // UPDATE MARKS
    // ============================================================

    public void setMarks(double marks) {

        this.marks = marks;
    }


    // ============================================================
    // DISPLAY STUDENT
    // ============================================================

    @Override
    public String toString() {

        return String.format(

            "ID: %-12s | Name: %-25s | Programme: %-20s | Marks: %.2f",

            studentId,
            name,
            programme,
            marks
        );
    }
}