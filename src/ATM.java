import java.util.Scanner;

public class ATM {
	
	public static void main(String[] args) {
		
		// initialize Scanner
		Scanner sc = new Scanner(System.in);
		
		// initialiez Bank
		Bank theBank = new Bank("Craiova Bank");
		
		// add a user, which also creates a savings account
		User aUser = theBank.addUser("Mihai", "Pop", "0000");
		
		// add a checking account for our user
		Account newAccount = new Account("Checking", aUser, theBank);
		aUser.addAccount(newAccount);
		theBank.addAccount(newAccount);
		
		User curUser;
		while(true) {
			
			// stay in the login prompt until successful login
			curUser = ATM.mainMenuPrompt(theBank, sc);
			
			// stay in main menu until user exits
			ATM.printUserMenu(curUser, sc);
			
		}
		
	}
	
	/**
	 * Print the ATM's login menu
	 * @param theBank	the Bank object whose accounts to use
	 * @param sc		the Scanner object to use for user input
	 * @return			the authenticated User object
	 */
	public static User mainMenuPrompt(Bank theBank, Scanner sc) {
		
		// initializations
		String userID;
		String pin;
		User authUser;
		
		// prompt the user for user ID/pin combo until a correct one is reached
		do {
			
			System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
			System.out.print("Enter user ID:");
			userID = sc.nextLine();
			System.out.printf("Enter pin: ");
			pin = sc.nextLine();
			
			// try to get the user object corresponding to the ID and pin combo
			authUser = theBank.userLogin(userID, pin);
			if(authUser == null) {
				System.out.println("Incorrect user ID/pin combination !" + "Please try again.");
				
			}
			
		} while(authUser == null);	// continue looping until successful login
		
		return authUser;
		
	}
	
	public static void printUserMenu(User theUser, Scanner sc) {
		
		// print a summary of the user's accounts
		theUser.printAccountsSummary();
		
		// initializations
		int choice;
		
		// user menu
		do {
			System.out.printf("Welcome %s, what would you like to do?", theUser.getFirstName());
			System.out.println("  1) Show account transaction history");
			System.out.println("  2) Withdraw");
			System.out.println("  3) Deposit");
			System.out.println("  4) Transfer");
			System.out.println("  5) Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			
			if (choice < 1 || choice > 5) {
				System.out.println("Invalid choice. Please select 1-5.");
			}
			
		} while(choice < 1 || choice > 5);
		
		// process the choice
		switch (choice) {
			
		case 1:
			ATM.showTransHistory(theUser, sc);
			break;
		case 2:
			ATM.withdrawFunds(theUser, sc);
			break;
		case 3:
			ATM.depositFunds(theUser, sc);
			break;
		case 4:
			ATM.transferFunds(theUser, sc);
			break;
			
		
		}
		
		// redisplay this menu unless the user wants to quit
		if(choice != 5) {
			ATM.printUserMenu(theUser, sc);
		}
		
	}
	
}
