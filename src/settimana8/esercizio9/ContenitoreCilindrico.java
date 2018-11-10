package settimana8.esercizio9;

public class ContenitoreCilindrico extends Contenitore {

	private double raggioBase, altezza;

	public ContenitoreCilindrico(String nome, String codice, double prezzo, double capienza, double raggioBase,
	                             double altezza) {
		super(nome, codice, prezzo, capienza);
		this.raggioBase = raggioBase;
		this.altezza = altezza;
	}

	public boolean equals(Object obj) {
		return super.equals(obj) && raggioBase == ((ContenitoreCilindrico) obj).raggioBase
				&& altezza == ((ContenitoreCilindrico) obj).altezza;
	}

	public String toString() {
		return getClass().getName() + "[nome=" + getNome() + ",codice=" + getCodice() + ",prezzo=" + getPrezzo()
				+ ",capienza=" + getCodice() + ",raggioBase=" + raggioBase + ",altezza=" + altezza + "]";
	}

	public Object clone() {
		return super.clone();
	}
}
