package settimana2.esercizio1;

import banking.BankAccount;

public class Customer implements Cloneable {

	private String nome, cognome;
	private BankAccount ba = new BankAccount(0);

	public Customer(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public void deposit(double amount) {
		ba.deposit(amount);
	}

	public void withdraw(double amount) {
		ba.withdraw(amount);
	}

	public Object clone() {
		try {
			Customer c = (Customer) super.clone();
			c.ba = (BankAccount) ba.clone();
			return c;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public void print() {
		System.out.println("Nome: " + nome);
		System.out.println("Cognome: " + cognome);
		ba.print();
	}

}
