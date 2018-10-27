package settimana2.esercizio2;

import settimana2.esercizio1.BankAccount;

public class SavingsAccount extends BankAccount {

	private double interestRate = 0;

	public SavingsAccount(double initialBalance, double initialInterestRate) {
		super(initialBalance);
		this.interestRate = initialInterestRate;
	}

	// To do every year.
	public void addInterest() {
		this.balance += balance * interestRate / 100;
	}

	/**
	 Gets the interest of the bank account.
	 @return the interest
	 */
	public double getInterestRate() {
		return interestRate;
	}

}
