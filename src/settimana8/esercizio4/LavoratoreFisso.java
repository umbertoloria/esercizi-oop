package settimana8.esercizio4;

public class LavoratoreFisso extends Lavoratore {

	public LavoratoreFisso(String nome, String cognome, double pagaOraria) {
		super(nome, cognome, pagaOraria);
	}

	@Override
	public double getPaga() {
		return getPagaOraria() * 40;
	}
}
