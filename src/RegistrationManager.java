import java.util.ArrayList;
import java.util.List;

public class RegistrationManager {

    private List<Registration> registrations;

    private StudentManager studentManager;
    private CourseManager courseManager;


    public RegistrationManager(
            StudentManager studentManager,
            CourseManager courseManager) {

        this.studentManager = studentManager;
        this.courseManager = courseManager;
        this.registrations = new ArrayList<>();
    }


    public boolean registerStudent(
            String studentId,
            String courseId) {

        if (studentId == null || courseId == null) {
            return false;
        }

        // Check if student exists
        Student student =
                studentManager.findStudentById(studentId);

        if (student == null) {
            return false;
        }


        Course course =
                courseManager.findCourseById(courseId);

        if (course == null || !course.isAvailable()) {
            return false;
        }

        // Prevent duplicate 
        for (Registration registration : registrations) {

            if (registration.getStudent().getStudentId()
                    .equals(studentId)
                    && registration.getCourse().getCourseId()
                    .equals(courseId)) {

                return false;
            }
        }


        Registration registration =
                new Registration(student, course);

        registrations.add(registration);

        return true;
    }

    // Display registered courses for a student
    public List<Course> getRegisteredCourses(String studentId) {

        List<Course> registeredCourses = new ArrayList<>();

        if (studentId == null) {
            return registeredCourses;
        }

        for (Registration registration : registrations) {

            if (registration.getStudent().getStudentId()
                    .equals(studentId)) {

                registeredCourses.add(registration.getCourse());
            }
        }

        return registeredCourses;
    }
}