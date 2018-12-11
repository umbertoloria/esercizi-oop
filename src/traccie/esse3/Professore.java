package traccie.esse3;

class Professore extends Account {

	private String corso;

	Professore(String nome, String cognome, String corso, String password) {
		super(nome, cognome, password);
		this.corso = corso;
	}

	String getCorso() {
		return corso;
	}
}
