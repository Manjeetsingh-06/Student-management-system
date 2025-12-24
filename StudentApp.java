import java.util.*;
public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Marks");
            System.out.println("9. View Top Scorer");
            System.out.println("10. Calculate Average Marks");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    Student s = new Student(roll, name, marks);
                    manager.addStudent(s);
                    break;
                case 2:
                    manager.viewAll();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    manager.searchByRollNo(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    manager.searchByName(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter roll number to update: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();
                    manager.updateStudent(r, newName, newMarks);
                    break;
                case 6:
                    System.out.print("Enter roll number to delete: ");
                    manager.deleteStudent(sc.nextInt());
                    break;
                case 7:
                    manager.sortByName();
                    break;
                case 8:
                    manager.sortByMarks();
                    break;
                case 9:
                    manager.topScorer();
                    break;
                case 10:
                    manager.averageMarks();
                    break;
                case 11:
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
