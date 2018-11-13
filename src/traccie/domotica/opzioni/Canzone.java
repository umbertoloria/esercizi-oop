package traccie.domotica.opzioni;

public class Canzone extends Opzione {

	private String autore;

	public Canzone(String autore, String titolo) {
		super(titolo);
		this.autore = autore;
	}

	public boolean equals(Object o) {
		return super.equals(o) && autore.equals(((Canzone) o).autore);
	}

	public String toString() {
		return autore + " - " + getNome();
	}

}
