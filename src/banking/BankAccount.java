package banking;

/**
 A Bank Account has a balance that can be changed by deposits and withdrawals. */
public class BankAccount implements Cloneable {

	private double balance;

	/**
	 Constructs a Bank Account with the initial balance assigned.
	 @param initialBalance will be the new initial balance
	 @throws IllegalArgumentException if the initial balance is negative
	 */
	public BankAccount(double initialBalance) {
		if (initialBalance < 0) {
			throw new IllegalArgumentException("The initial balance must not be negative.");
		}
		this.balance = initialBalance;
	}

	/**
	 Deposits money into the Bank Account.
	 @param amount will be deposited
	 @throws IllegalArgumentException if the amount is not positive
	 */
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("The deposit amount must be positive.");
		}
		this.balance += amount;
	}

	/**
	 Withdraws money from the Bank Account.
	 @param amount will be withdrawn
	 @throws IllegalArgumentException if the amount is not positive or if there is not enough money
	 */
	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("The amount must be positive.");
		} else if (amount > balance) {
			throw new IllegalArgumentException("There is not enough money.");
		}
		this.balance -= amount;
	}

	/**
	 Gets the current balance of the Bank Account.
	 @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 Takes out an amount of money and give them to another Bank Account.
	 @param amount is the quantity of money that will be transferred
	 @param other  will get the amount of money, taken out from the bank account that's willing to transfer the money
	 */
	void transfer(double amount, BankAccount other) {
		this.withdraw(amount);
		other.deposit(amount);
	}

	public String toString() {
		return getClass().getName() + "[balance=" + balance + "]";
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public void print() {
		System.out.println(this);
		System.out.printf("Saldo: %6.2f€\n", balance);
	}

}
