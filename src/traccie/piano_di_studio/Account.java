package traccie.piano_di_studio;

class Account {

	private String nome, cognome, password;

	Account(String nome, String cognome, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
	}

	boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	String getNomeCompleto() {
		return cognome + " " + nome;
	}

}
