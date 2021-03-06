package banking;

/**
 A Bank Account that charges fees for each transaction over the free transactions limit given. */
public class CheckingAccount extends BankAccount {

	private static final int FREE_TRANSACTIONS = 3;
	private static final double TRANSACTION_FEE = 2;

	private int transactionCount = 0;

	/**
	 Constructs a Checking Account with the initial balance assigned.
	 @param initialBalance will be the new initial balance
	 @throws IllegalArgumentException if the initial balance is negative
	 */
	CheckingAccount(double initialBalance) {
		super(initialBalance);
	}

	public void deposit(double amount) {
		super.deposit(amount);
		transactionCount++;
	}

	public void withdraw(double amount) {
		super.withdraw(amount);
		transactionCount++;
	}

	/**
	 Withdraws the fees on every transaction over the free transactions limit given.
	 */
	void deductFees() {
		if (transactionCount > FREE_TRANSACTIONS) {
			super.withdraw(TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS));
		}
		transactionCount = 0;
	}

	public String toString() {
		return getClass().getName() + "[balance=" + getBalance() + ",transactionCount=" + transactionCount + "]";
	}

}
