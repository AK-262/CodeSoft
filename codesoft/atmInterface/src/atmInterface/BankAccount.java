package atmInterface;
import java.util.Scanner;

public class BankAccount {
	
	    private double balance;

	    // Constructor to initialize the balance
	    public BankAccount(double initialBalance) {
	        this.balance = initialBalance;
	    }

	    // Method to deposit money
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposit Successful! Amount Deposited: Rs." + amount);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Method to withdraw money
	    public boolean withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal Successful! Amount Withdrawn: Rs." + amount);
	            return true;
	        } else if (amount > balance) {
	            System.out.println("Insufficient balance for withdrawal.");
	            return false;
	        } else {
	            System.out.println("Invalid withdrawal amount.");
	            return false;
	        }
	    }

	    // Method to check balance
	    public double checkBalance() {
	        return balance;
	    }
	}

	// Class representing the ATM machine
	class ATM {
	    private BankAccount account;

	    // Constructor to connect the ATM with a bank account
	    public ATM(BankAccount account) {
	        this.account = account;
	    }

	    // Display the ATM user interface
	    public void displayMenu() {
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("\n--- ATM Menu ---");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Exit");

	            System.out.print("Choose an option (1-4): ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    checkBalance();
	                    break;
	                case 2:
	                    deposit(scanner);
	                    break;
	                case 3:
	                    withdraw(scanner);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM. Have a nice day!");
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose between 1-4.");
	            }
	        }
	    }

	    // Method to check balance
	    private void checkBalance() {
	        double balance = account.checkBalance();
	        System.out.printf("Your current balance is: Rs.%.2f\n", balance);
	        printReceipt("Balance Inquiry", 0, balance);
	    }

	    // Method to deposit money
	    private void deposit(Scanner scanner) {
	        System.out.print("Enter the amount to deposit: Rs.");
	        double amount = scanner.nextDouble();
	        account.deposit(amount);
	        printReceipt("Deposit", amount, account.checkBalance());
	    }

	    // Method to withdraw money
	    private void withdraw(Scanner scanner) {
	        System.out.print("Enter the amount to withdraw: Rs.");
	        double amount = scanner.nextDouble();
	        if (account.withdraw(amount)) {
	            printReceipt("Withdrawal", amount, account.checkBalance());
	        }
	    }

	    // Method to print a mini-receipt after each transaction
	    private void printReceipt(String transactionType, double amount, double balanceAfter) {
	        System.out.println("\n--- Transaction Receipt ---");
	        System.out.println("Transaction: " + transactionType);
	        if (transactionType.equals("Deposit") || transactionType.equals("Withdrawal")) {
	            System.out.printf("Amount: Rs..%.2f\n", amount);
	        }
	        System.out.printf("Remaining Balance: Rs.%.2f\n", balanceAfter);
	        System.out.println("----------------------------\n");
	    }
	}

	// Main class to run the ATM system



