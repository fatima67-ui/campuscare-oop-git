package person;

public class Student extends Person {
    private final String program;
    private int semester;

    // Constructor
    public Student(int id, String name, String email, String program, int semester) {
        super(id, name, email); // parent constructor call
        this.program = program;
        this.semester = semester;
    }

    // Getters
    public String getProgram() {
        return program;
    }

    public int getSemester() {
        return semester;
    }
}