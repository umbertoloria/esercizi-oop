package banking;

/**
 A Bank Account that matures flat fees interests. */
public class SavingsAccount extends BankAccount {

	private double interestRate;

	/**
	 Constructs a Savings Account with the initial balance assigned.
	 @param initialBalance      will be the new initial balance
	 @param initialInterestRate will be the initial interest rate
	 @throws IllegalArgumentException if the initial balance is negative
	 */
	SavingsAccount(double initialBalance, double initialInterestRate) {
		super(initialBalance);
		this.interestRate = initialInterestRate;
	}

	/**
	 Adds interests on the Savings Account. Do it once a year!
	 */
	void addInterest() {
		deposit(getBalance() * interestRate / 100);
	}

	public String toString() {
		return getClass().getName() + "[balance=" + getBalance() + ",interestRate=" + interestRate + "]";
	}

}
