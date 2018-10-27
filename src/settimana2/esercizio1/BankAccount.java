package settimana2.esercizio1;

import settimana6.interfacce.Measurable;

public class BankAccount implements Measurable {

	protected double balance;

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	/**
	 Deposits money into the bank account.
	 @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 Withdraws moneyu from the bank account.
	 @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	/**
	 Gets the current balance of the bank account.
	 @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 Gets the measure of the bank account.
	 @return the measure
	 */
	public double getMeasure() {
		return balance;
	}

	public void print() {
		System.out.printf("Saldo: %6.2f €", balance);
	}

}
