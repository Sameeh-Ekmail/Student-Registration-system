
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    // Add a new student
    public boolean addStudent(Student student) {

        if (student == null ||
            student.getStudentId() == null ||
            student.getStudentId().isBlank() ||
            student.getName() == null ||
            student.getName().isBlank()) {
            return false;
        }

        if (findStudentById(student.getStudentId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    // Find a student 
    public Student findStudentById(String studentId) {

        if (studentId == null) {
            return null;
        }

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }

        return null;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
