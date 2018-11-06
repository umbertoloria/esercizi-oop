package banking;

import settimana2.esercizio1.Customer;

public class AccountTest {

	public static void mainTest() {
		BankAccount mamma = new SavingsAccount(10000, .5);
		BankAccount umberto = new CheckingAccount(100);

		mamma.transfer(2000, umberto);
		umberto.withdraw(1500);
		umberto.withdraw(80);

		mamma.transfer(1000, umberto);
		umberto.withdraw(400);

		((SavingsAccount) mamma).addInterest();
		((CheckingAccount) umberto).deductFees();

		mamma.print();
		umberto.print();
	}

	public static void mainCloneCustomer() {
		Customer a = new Customer("Umberto", "Loria");
		a.deposit(1000);

		Customer b = (Customer) a.clone();
		b.deposit(100);

		a.print();
		System.out.println();
		b.print();
	}

	public static void mainCloneSavingsAccount() {
		SavingsAccount a = new SavingsAccount(120, 10);
		SavingsAccount b = (SavingsAccount) a.clone();
		a.deposit(1000);

		a.print();
		System.out.println();
		b.print();
	}

}
