package studentGradeCalculator;
import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Welcome to the Student Grade Calculator!");

		        // Get the number of subjects
		        System.out.print("Enter the number of subjects: ");
		        int numSubjects = scanner.nextInt();

		        int[] marks = new int[numSubjects];
		        int totalMarks = 0;

		        // Taking marks input from user with validation
		        for (int i = 0; i < numSubjects; i++) {
		            while (true) {
		                System.out.print("Enter marks for subject " + (i + 1) + " (0 to 100): ");
		                marks[i] = scanner.nextInt();
		                if (marks[i] >= 0 && marks[i] <= 100) {
		                    break;
		                } else {
		                    System.out.println("Invalid input. Marks should be between 0 and 100. Try again.");
		                }
		            }
		            totalMarks += marks[i];
		        }

		        // Calculate average percentage
		        double averagePercentage = (double) totalMarks / numSubjects;

		        // Calculate grade
		        String grade = calculateGrade(averagePercentage);

		        // Display results
		        System.out.println("\n--- Student Grade Report ---");
		        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
		        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
		        System.out.println("Grade: " + grade);
		        System.out.println(getRemark(grade));
		    }

		    // Method to calculate grade based on percentage
		    public static String calculateGrade(double percentage) {
		        if (percentage >= 90) {
		            return "A+";
		        } else if (percentage >= 80) {
		            return "A";
		        } else if (percentage >= 70) {
		            return "B+";
		        } else if (percentage >= 60) {
		            return "B";
		        } else if (percentage >= 50) {
		            return "C";
		        } else if (percentage >= 40) {
		            return "D";
		        } else {
		            return "F";
		        }
		    }

		    // Method to provide a remark based on grade
		    public static String getRemark(String grade) {
		        switch (grade) {
		            case "A+":
		                return "Excellent performance! Keep up the great work.";
		            case "A":
		                return "Great job! You’re on the right track.";
		            case "B+":
		                return "Good work! You can aim for higher.";
		            case "B":
		                return "Decent effort! There's room for improvement.";
		            case "C":
		                return "Fair performance. Try to focus more on studies.";
		            case "D":
		                return "Needs improvement. Consistent effort is required.";
		            case "F":
		                return "Unfortunately, you failed. Don't be disheartened, seek help and try again.";
		            default:
		                return "";
		        }
		    }
		}


