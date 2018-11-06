package banking;

/**
 A Bank Account that matures flat fees interests. */
public class SavingsAccount extends BankAccount {

	private double interestRate;

	/**
	 Constructs a Savings Account with the initial balance assigned.
	 @param initialBalance      will be the new initial balance
	 @param initialInterestRate will be the initial interest rate
	 */
	public SavingsAccount(double initialBalance, double initialInterestRate) {
		super(initialBalance);
		this.interestRate = initialInterestRate;
	}

	/**
	 Adds interests on the Savings Account. Do it once a year!
	 */
	public void addInterest() {
		deposit(getBalance() * interestRate / 100);
	}

	/**
	 Gets the interest of the Savings Account.
	 @return the interest
	 */
	public double getInterestRate() {
		return interestRate;
	}

}
