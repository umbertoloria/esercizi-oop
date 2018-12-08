package traccie.hotel.clienti;

public class Cliente {

	private String cognome, nome, telefono, cartaDiCredito;

	public Cliente(String cognome, String nome, String telefono, String cartaDiCredito) {
		if (nome.isEmpty() || cognome.isEmpty() || telefono.isEmpty() || cartaDiCredito.isEmpty()) {
			throw new RuntimeException("Devi compilare tutti i campi.");
		}
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.cartaDiCredito = cartaDiCredito;
	}

	public String getNomeCompleto() {
		return cognome + " " + nome;
	}

	public String toString() {
		return cognome + " " + nome + " " + telefono + " " + cartaDiCredito;
	}

	String toFileRow() {
		return cognome + "\t" + nome + "\t" + telefono + "\t" + cartaDiCredito;
	}

}
