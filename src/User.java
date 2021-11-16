import java.util.ArrayList;

public class User {
	
	// data for each account
	
	// The first name of the user
	private String firstName;
	
	// The last name of the user
	private String lastName;
	
	// The ID number of the user
	private String uuid;
	
	// Hash for user's pin number
	private byte pinHash[];
	
	// List of accounts for this user
	private ArrayList<Account> accounts;
	
}
