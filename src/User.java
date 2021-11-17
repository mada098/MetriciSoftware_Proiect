import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	
	// data for each account
	
	// The first name of the user
	private String firstName;
	
	// The last name of the user
	private String lastName;
	
	// The ID number of the user
	private String uuid;
	
	// MD5 hash for user's pin number
	private byte pinHash[];
	
	// List of accounts for this user
	private ArrayList<Account> accounts;
	
	
	/**
	 * Create a new user
	 * @param firstName the user's first name
	 * @param lastName  the user's last name
	 * @param pin		the user's account pin number
	 * @param theBank	the Bank object that the user is a customer of
	 */
	
	// Constructor
	public User(String firstName, String lastName, String pin, Bank theBank) {
		
		// set user's name
		this.firstName = firstName;
		this.lastName = lastName;
		
		// store the pin's MD5 hash instead of original value,
		// for security purposes
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		// get a new unique universal ID for the user
		this.uuid = theBank.getNewUserUUID();
		
		// create empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		// print log message
		System.out.printf("New user %s, %s with ID %s created\n", lastName,
				firstName, this.uuid);
		
	}
	
	/**
	 * Add an account for the user
	 * @param anAcct	the account to add
	 */
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	/**
	 * Return the user's UUID
	 * @return	the uuid
	 */
	public String getUUID() {
		return this.uuid;
	}
	
	/**
	 * Check whether a given pin matches the true User pin
	 * @param aPin	the pin to check
	 * @return		whether the pin is valid or not
	 */
	public boolean validatePin(String aPin) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		return false;
		
	}
	
	/**
	 * Return the user's first name
	 * @return	the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
}
