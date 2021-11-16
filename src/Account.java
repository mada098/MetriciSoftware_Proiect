import java.util.ArrayList;

public class Account {

	// data for an account
	
	// Account name
	private String name;
	
	// Account ID number
	private String uuid;
	
	// User object that owns the account
	private User holder;
	
	// List of transactions for this account
	private ArrayList<Transaction> transactions;
	
	
	/**
	 * Create a new account
	 * @param name		the name of the account
	 * @param holder	the User object that holds this account
	 * @param theBank	the bank that issues the account
	 */
	
	// Constructor
	public Account(String name, User holder, Bank theBank) {
		
		// set the account name and holder
		this.name = name;
		this.holder = holder;
		
		// get new account UUID
		this.uuid = theBank.getNewAccountUUID();
		
		// initialize transactions
		this.transactions = new ArrayList<Transaction>();
		
	}
	
	/**
	 * Get the account ID
	 * @return	the uuid
	 */
	public String getUUID() {
		return this.uuid;
	}
	
}
