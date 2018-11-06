package banking;

public class AccountTest {

	public static void main() {
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

}
