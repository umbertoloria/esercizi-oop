package settimana2.esercizio1;

public class BankAccount {

	protected double balance = 0;

	public BankAccount() {
	}

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	/**
	 * @param amount Quota da aggiungere al bilancio.
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 * @param amount Quota da diminuire al bilancio.
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	/**
	 * @return Fornisce il bilancio corrente.
	 */
	public double getBalance() {
		return balance;
	}

	public void print() {
		System.out.printf("Saldo: %6.2f €", balance);
	}
}
