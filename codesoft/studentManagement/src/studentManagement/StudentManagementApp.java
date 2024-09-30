package studentManagement;
import java.util.Scanner;

public class StudentManagementApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Data");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    sms.addStudent(name, rollNumber, grade);
                    break;

                case 2:
                    // Remove a student
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    sms.removeStudent(removeRollNumber);
                    break;

                case 3:
                    // Search for a student
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student student = sms.searchStudent(searchRollNumber);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Display all students
                    sms.displayAllStudents();
                    break;

                case 5:
                    // Save data to file
                    sms.saveData();
                    break;

                case 6:
                    // Exit the application
                    sms.saveData();  // Save data before exiting
                    System.out.println("Exiting the application.");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
	}

}
