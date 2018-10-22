package settimana2.esercizio1;

public class Customer {

	private String nome, cognome;
	private BankAccount ba = new BankAccount();

	public Customer(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public void print() {
		System.out.println("Nome: " + nome);
		System.out.println("Cognome: " + cognome);
		ba.print();
		System.out.println();
	}

}
