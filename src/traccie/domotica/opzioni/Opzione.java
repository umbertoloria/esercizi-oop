package traccie.domotica.opzioni;

public class Opzione {

	private String nome;

	public Opzione(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String toString() {
		return nome;
	}

	public boolean equals(Object o) {
		if (o != null && getClass() == o.getClass()) {
			return nome.equals(((Opzione) o).nome);
		}
		return false;
	}

}
