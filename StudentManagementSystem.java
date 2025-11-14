import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}


// Main Management System
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);
    }

    // Add student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // Clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student Added Successfully!");
    }

    // View all students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        System.out.println("\n---- Student List ----");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Update student
    public static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();

                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);

                System.out.println("Record Updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete student
    public static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Record Deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
