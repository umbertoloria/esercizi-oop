package traccie.concessionaria.mezzi;

import traccie.concessionaria.exceptions.TargaErrataException;

public class Motociclo extends Automezzo {

	private static final long serialVersionUID = 1000100010001000103L;
	public static final String targaFormat = "LLNNNNN";

	private int numeroRuote, numeroPasseggeri;

	public Motociclo(String marca, String modello, String targa, int anno, int numeroRuote, int numeroPasseggeri)
			throws TargaErrataException {
		super(marca, modello, targa, anno, targaFormat);
		this.numeroRuote = numeroRuote;
		this.numeroPasseggeri = numeroPasseggeri;
	}

	public int getNumeroRuote() {
		return numeroRuote;
	}

	public Object[] getTableRow() {
		return new Object[]{getMarca(), getModello(), getTarga(), getAnno() + "", numeroRuote + "",
				numeroPasseggeri + ""};
	}

}
