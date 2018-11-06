package banking;

/**
 A Bank Account has a balance that can be changed by deposits and withdrawals. */
public class BankAccount {

	private double balance;

	/**
	 Constructs a Bank Account with the initial balance assigned.
	 @param initialBalance will be the new initial balance
	 */
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	/**
	 Deposits money into the Bank Account.
	 @param amount will be deposited
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 Withdraws money from the Bank Account.
	 @param amount will be withdrawn
	 */
	public void withdraw(double amount) {
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
	public void transfer(double amount, BankAccount other) {
		withdraw(amount);
		other.deposit(amount);
	}

	public void print() {
		System.out.printf("Saldo: %6.2f €\n", balance);
	}

}
