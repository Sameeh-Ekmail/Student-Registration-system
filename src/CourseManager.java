
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private final List<Course> courses = new ArrayList<>();

    // Add a new course
    public boolean addCourse(Course course) {

        if (course == null ||
            course.getCourseId() == null ||
            course.getCourseId().isBlank() ||
            course.getCourseName() == null ||
            course.getCourseName().isBlank()) {
            return false;
        }

        if (findCourseById(course.getCourseId()) != null) {
            return false;
        }

        courses.add(course);
        return true;
    }

    // Find a course 
    public Course findCourseById(String courseId) {

        if (courseId == null) {
            return null;
        }

        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    // Get available courses
    public List<Course> getAvailableCourses() {

        List<Course> availableCourses = new ArrayList<>();

        for (Course course : courses) {
            if (course.isAvailable()) {
                availableCourses.add(course);
            }
        }

        return availableCourses;
    }
}
