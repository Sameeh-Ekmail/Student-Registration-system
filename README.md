
# Student Course Registration System

## Project Description
A Java-based application designed to manage students, courses, and course registrations.

## Features
1. Add a Student.
2. Add a Course.
3. Display Available Courses.
4. Register a Student in a Course.
5. Display a Student's Registered Courses.

## Technologies
- Java
- Git
- GitHub

## Project Structure
- Student.java
- Course.java
- StudentManager.java
- CourseManager.java
- Registration.java
- RegistrationManager.java
- Main.java

## How to Run

Compile the source files:

```bash
javac -d out src/Student.java src/Course.java src/StudentManager.java src/CourseManager.java src/Registration.java src/RegistrationManager.java src/Main.java
```

Run the application:

```bash
java -cp out Main
```

## Validation Rules

- Each student must have a unique student ID.
- Each course must have a unique course ID.
- Students cannot register for non-existing courses.
- Duplicate registrations are not allowed.
- Multiple students can register in the same course.

## Data Storage

The application uses ArrayList to store data
temporarily during program execution.
