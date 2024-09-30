package numberGame;
//TODO Auto-generated method stub
import java.util.Scanner;
import java.util.Random;
public class GuessTheNumberGame {

	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();
		        boolean playAgain = true;
		        int totalScore = 0;
		        int round = 1;
		        
		        System.out.println("Welcome to 'Guess the Number' Game!");

		        // Game loop for multiple rounds
		        while (playAgain) {
		            System.out.println("\n--- Round " + round + " ---");
		            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
		            int attemptsLeft = 5; // Limit attempts to 5
		            int roundScore = 0;
		            boolean guessedCorrectly = false;

		            System.out.println("I have selected a number between 1 and 100. Can you guess it?");
		            System.out.println("You have " + attemptsLeft + " attempts to guess the number.");

		            // Guessing loop for the current round
		            while (attemptsLeft > 0 && !guessedCorrectly) {
		                System.out.print("Enter your guess: ");
		                int userGuess = scanner.nextInt();
		                attemptsLeft--;

		                if (userGuess == numberToGuess) {
		                    guessedCorrectly = true;
		                    roundScore = 10 + attemptsLeft * 2; // Bonus points for fewer attempts
		                    totalScore += roundScore;
		                    System.out.println("Congratulations! You guessed the correct number.");
		                    System.out.println("You scored " + roundScore + " points this round.");
		                } else if (userGuess > numberToGuess) {
		                    System.out.println("Too high! Try again.");
		                } else {
		                    System.out.println("Too low! Try again.");
		                }

		                if (!guessedCorrectly && attemptsLeft > 0) {
		                    System.out.println("Attempts remaining: " + attemptsLeft);
		                }
		            }

		            if (!guessedCorrectly) {
		                System.out.println("You've run out of attempts! The correct number was: " + numberToGuess);
		            }

		            System.out.println("Your total score so far: " + totalScore);

		            // Asking if the user wants to play another round
		            System.out.print("Do you want to play another round? (yes/no): ");
		            playAgain = scanner.next().equalsIgnoreCase("yes");
		            round++;
		        }

		        System.out.println("\nGame Over! You played " + (round - 1) + " rounds.");
		        System.out.println("Your final score: " + totalScore);
		        System.out.println("Thanks for playing! See you next time.");
		        scanner.close();
	}

}
