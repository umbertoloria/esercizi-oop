package traccie.concessionaria.mezzi;

import traccie.concessionaria.exceptions.TargaErrataException;

public class Autoveicolo extends Automezzo {

	private static final long serialVersionUID = 1000100010001000102L;
	public static final String targaFormat = "LLNNNLL";
	private String alimentazione;
	private int numeroPorte, numeroPosti;

	public Autoveicolo(String marca, String modello, String targa, int anno, String alimentazione, int numeroPorte,
	                   int numeroPosti) throws TargaErrataException {
		super(marca, modello, targa, anno, targaFormat);
		this.alimentazione = alimentazione;
		this.numeroPorte = numeroPorte;
		this.numeroPosti = numeroPosti;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public Object[] getTableRow() {
		return new Object[]{getMarca(), getModello(), getTarga(), getAnno() + "", alimentazione, numeroPorte + "",
				numeroPosti + ""};
	}

}
