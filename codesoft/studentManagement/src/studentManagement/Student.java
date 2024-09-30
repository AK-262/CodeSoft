package studentManagement;
import java.io.*;
import java.util.ArrayList;
public class Student {

	 private String name;
	    private int rollNumber;
	    private String grade;

	    // Constructor to initialize a student
	    public Student(String name, int rollNumber, String grade) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.grade = grade;
	    }

	    // Getter methods
	    public String getName() {
	        return name;
	    }

	    public int getRollNumber() {
	        return rollNumber;
	    }

	    public String getGrade() {
	        return grade;
	    }

	    // Setter methods to edit student details
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setRollNumber(int rollNumber) {
	        this.rollNumber = rollNumber;
	    }

	    public void setGrade(String grade) {
	        this.grade = grade;
	    }

	    @Override
	    public String toString() {
	        return "Student[Name=" + name + ", Roll Number=" + rollNumber + ", Grade=" + grade + "]";
	    }
	}

	// Class to manage a collection of students
	class StudentManagementSystem {
	    private ArrayList<Student> students;
	    private final String fileName = "students.txt";  // File for storing student data

	    // Constructor to initialize student list
	    public StudentManagementSystem() {
	        students = new ArrayList<>();
	        loadData(); // Load data from file when system starts
	    }

	    // Method to add a student
	    public void addStudent(String name, int rollNumber, String grade) {
	        students.add(new Student(name, rollNumber, grade));
	        System.out.println("Student added successfully!");
	    }

	    // Method to remove a student
	    public void removeStudent(int rollNumber) {
	        Student student = searchStudent(rollNumber);
	        if (student != null) {
	            students.remove(student);
	            System.out.println("Student removed successfully!");
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    // Method to search for a student by roll number
	    public Student searchStudent(int rollNumber) {
	        for (Student student : students) {
	            if (student.getRollNumber() == rollNumber) {
	                return student;
	            }
	        }
	        return null;  // Return null if student not found
	    }

	    // Method to display all students
	    public void displayAllStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students available.");
	        } else {
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }

	    // Method to save student data to file
	    public void saveData() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            for (Student student : students) {
	                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
	                writer.newLine();
	            }
	            System.out.println("Data saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Error saving data.");
	        }
	    }

	    // Method to load student data from file
	    public void loadData() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(",");
	                if (data.length == 3) {
	                    students.add(new Student(data[0], Integer.parseInt(data[1]), data[2]));
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Data file not found. Starting with an empty list.");
	        } catch (IOException e) {
	            System.out.println("Error loading data.");
	        }
	    }
}
