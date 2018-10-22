package settimana2.esercizio1;

public class BankAccount {

	protected double balance = 0;

	public BankAccount() {
	}

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}

	public double getBalance() {
		return balance;
	}

	public void print() {
		System.out.printf("Saldo: %6.2f €", balance);
	}
}
