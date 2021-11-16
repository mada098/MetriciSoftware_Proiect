import java.util.ArrayList;

public class Account {

	// data for an account
	
	// Account name
	private String name;
	
	// Account's current balance
	private double balance;
	
	// Account ID number
	private String uuid;
	
	// User object that owns the account
	private User holder;
	
	// List of transactions for this account
	private ArrayList<Transaction> transactions;
	
}
