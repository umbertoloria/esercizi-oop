package settimana8.esercizio9;

public class ContenitoreCubico extends Contenitore {

	private double lato;

	public ContenitoreCubico(String nome, String codice, double prezzo, double capienza, double lato) {
		super(nome, codice, prezzo, capienza);
		this.lato = lato;
	}

	public double getLato() {
		return lato;
	}

	public void setLato(double lato) {
		this.lato = lato;
	}

	public String toString() {
		return getClass().getName() + "[nome=" + getNome() + ",codice=" + getCodice() + ",prezzo=" + getPrezzo()
				+ ",capienza=" + getCodice() + ",lato=" + lato + "]";
	}

	public boolean equals(Object obj) {
		return super.equals(obj) && lato == ((ContenitoreCubico) obj).lato;
	}

	public Object clone() {
		return super.clone();
	}
}
