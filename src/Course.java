
public class Course {

    // Course attributes
    private String courseId;
    private String courseName;
    private boolean available;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.available = true;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isAvailable() {
        return available;
    }

    // Update course availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId
                + ", Course Name: " + courseName;
    }
}
