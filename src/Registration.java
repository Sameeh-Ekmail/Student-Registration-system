import java.time.LocalDate;

public class Registration {

    private Student student;
    private Course course;
    private LocalDate registrationDate;


    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.registrationDate = LocalDate.now();
    }


    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // Display registration information
    @Override
    public String toString() {
        return "Student: " + student.getName()
                + " (" + student.getStudentId() + ")"
                + ", Course: " + course.getCourseName()
                + " (" + course.getCourseId() + ")"
                + ", Date: " + registrationDate;
    }
}