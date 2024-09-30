package atmInterface;

public class ATMInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize the user's bank account with an initial balance
        BankAccount account = new BankAccount(1000.00); // Starting balance of $1000

        // Create the ATM object linked with the user's bank account
        ATM atm = new ATM(account);

        // Display the ATM menu
        atm.displayMenu();
	}

}
