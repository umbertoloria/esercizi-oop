package settimana2.esercizio2;

import settimana2.esercizio1.BankAccount;

public class SavingsAccount extends BankAccount {

	private double interestRate = 0;

	public SavingsAccount(double initialBalance, double initialInterestRate) {
		super(initialBalance);
		this.interestRate = initialInterestRate;
	}

	public void addInterest() {
		this.balance += interestRate / 100 * balance;
	}

	public double getInterestRate() {
		return interestRate;
	}


}
