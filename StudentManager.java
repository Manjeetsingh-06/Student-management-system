import java.util.*;

// StudentManager.java
// Handles all student operations
public class StudentManager {
    private final ArrayList<Student> studentList = new ArrayList<>();

    // Add a new student
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewAll() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // Search student by roll number
    public void searchByRollNo(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search student by name
    public void searchByName(String name) {
        boolean found = false;
        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("No matching student found.");
    }

    // Update student details
    public void updateStudent(int rollNo, String newName, int newMarks) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete student
    public void deleteStudent(int rollNo) {
        studentList.removeIf(s -> s.getRollNo() == rollNo);
        System.out.println("Student deleted (if existed).");
    }

    // Sort by name
    public void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by name.");
    }

    // Sort by marks (descending)
    public void sortByMarks() {
        studentList.sort((a, b) -> b.getMarks() - a.getMarks());
        System.out.println("Students sorted by marks.");
    }

    // View top scorer
    public void topScorer() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Student top = Collections.max(studentList, Comparator.comparing(Student::getMarks));
        System.out.println("Top Scorer: " + top);
    }

    // Calculate average marks
    public void averageMarks() {
        if (studentList.isEmpty()) {
            System.out.println("No students to calculate average.");
            return;
        }
        double avg = studentList.stream().mapToInt(Student::getMarks).average().orElse(0);
        System.out.println("Average Marks: " + avg);
    }
}
