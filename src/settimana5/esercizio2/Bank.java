package settimana5.esercizio2;

import settimana2.esercizio1.BankAccount;

import java.util.Hashtable;

public class Bank {

	private Hashtable<String, BankAccount> accounts = new Hashtable<>();

	public void addAccount(String customerName, double initialBalance) {
		accounts.put(customerName, new BankAccount(initialBalance));
	}

	public void deposit(String account, double amount) throws RuntimeException {
		BankAccount ba = accounts.get(account);
		if (ba == null) {
			throw new RuntimeException();
		}
		ba.deposit(amount);
	}

	public void withdraw(String account, double amount) throws RuntimeException {
		BankAccount ba = accounts.get(account);
		if (ba == null) {
			throw new RuntimeException();
		}
		ba.withdraw(amount);
	}

	public double getBalance(String account) throws RuntimeException {
		BankAccount ba = accounts.get(account);
		if (ba == null) {
			throw new RuntimeException();
		}
		return ba.getBalance();
	}

	public void transfer(String fromAccount, String toAccount, double amount) throws RuntimeException {
		BankAccount from = accounts.get(fromAccount);
		if (from == null) {
			throw new RuntimeException();
		}
		BankAccount to = accounts.get(toAccount);
		if (to == null) {
			throw new RuntimeException();
		}
		from.withdraw(amount);
		to.deposit(amount);
	}

	public static void test() {
		Bank a = new Bank();

		a.addAccount("umberto", 1000);
		a.addAccount("michele", 500);

		System.out.println("umberto " + a.getBalance("umberto"));
		System.out.println("michele " + a.getBalance("michele"));

		a.transfer("umberto", "michele", 50);

		System.out.println("umberto " + a.getBalance("umberto"));
		System.out.println("michele " + a.getBalance("michele"));
	}

}
