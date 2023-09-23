
import java.util.Scanner;
import java.util.List;

public class StudentManagementApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentManagementSystem system = new StudentManagementSystem();

            // Load data from file if available
            system.loadDataFromFile();

            while (true) {
                System.out.println("Student Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Save Data to File");
                System.out.println("6. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Roll Number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        System.out.print("Enter Grade: ");
                        String grade = scanner.nextLine();

                        Student student = new Student(name, rollNumber, grade);
                        system.addStudent(student);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter Roll Number to remove: ");
                        int removeRollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        system.removeStudent(removeRollNumber);
                        System.out.println("Student removed successfully.");
                        break;
                    case 3:
                        System.out.print("Enter Roll Number to search: ");
                        int searchRollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        Student foundStudent = system.searchStudent(searchRollNumber);
                        if (foundStudent != null) {
                            System.out.println("Student found:\n" + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        List<Student> allStudents = system.getAllStudents();
                        System.out.println("All Students:");
                        for (Student s : allStudents) {
                            System.out.println(s);
                        }
                        break;
                    case 5:
                        system.saveDataToFile();
                        break;
                    case 6:
                        System.out.println("Exiting the application.");
                        system.saveDataToFile();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
