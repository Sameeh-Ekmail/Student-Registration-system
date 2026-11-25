import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Create managers
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();

        RegistrationManager registrationManager =
                new RegistrationManager(studentManager, courseManager);

        boolean running = true;

        while (running) {

            System.out.println("\n==================================");
            System.out.println(" Student Course Registration System");
            System.out.println("==================================");
            System.out.println("1. Add a Student");
            System.out.println("2. Add a Course");
            System.out.println("3. Display Available Courses");
            System.out.println("4. Register a Student in a Course");
            System.out.println("5. Display a Student's Registered Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    addStudent(studentManager);
                    break;

                case "2":
                    addCourse(courseManager);
                    break;

                case "3":
                    displayAvailableCourses(courseManager);
                    break;

                case "4":
                    registerStudent(registrationManager);
                    break;

                case "5":
                    displayRegisteredCourses(registrationManager, studentManager);
                    break;

                case "0":
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addStudent(StudentManager manager) {

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        Student student = new Student(studentId, name);

        if (manager.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student. Check the information or ID.");
        }
    }

    private static void addCourse(CourseManager manager) {

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine().trim();

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine().trim();

        Course course = new Course(courseId, courseName);

        if (manager.addCourse(course)) {
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Failed to add course. Check the information or ID.");
        }
    }

    private static void displayAvailableCourses(CourseManager manager) {

        List<Course> courses = manager.getAvailableCourses();

        if (courses.isEmpty()) {
            System.out.println("No available courses found.");
            return;
        }

        System.out.println("\nAvailable Courses:");

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void registerStudent(RegistrationManager manager) {

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine().trim();

        if (manager.registerStudent(studentId, courseId)) {
            System.out.println("Registration completed successfully!");
        } else {
            System.out.println(
                    "Registration failed. Student or course may not exist, "
                    + "or the student is already registered."
            );
        }
    }

    private static void displayRegisteredCourses(
            RegistrationManager registrationManager,
            StudentManager studentManager) {

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        if (studentManager.findStudentById(studentId) == null) {
            System.out.println("Student not found.");
            return;
        }

        List<Course> courses =
                registrationManager.getRegisteredCourses(studentId);

        if (courses.isEmpty()) {
            System.out.println("This student has no registered courses.");
            return;
        }

        System.out.println("\nRegistered Courses:");

        for (Course course : courses) {
            System.out.println(course);
        }
    }
}