package traccie.concessionaria.mezzi;

import traccie.concessionaria.exceptions.BadDataFormatException;
import traccie.concessionaria.exceptions.TargaErrataException;

import java.io.Serializable;

public abstract class Automezzo implements Serializable {

	private static final long serialVersionUID = 1000100010001000101L;

	private String modello, marca, targa;
	private int anno;

	Automezzo(String marca, String modello, String targa, int anno, String formatoTarga)
			throws TargaErrataException {
		checkTarga(targa, formatoTarga);
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.anno = anno;
	}

	String getMarca() {
		return marca;
	}

	String getModello() {
		return modello;
	}

	public String getTarga() {
		return targa;
	}

	public int getAnno() {
		return anno;
	}

	public String toString() {
		return marca + " - " + modello + " - " + targa + " - " + anno;
	}

	public abstract Object[] getTableRow();

	public static void checkTarga(String targa, String formatoTarga) throws TargaErrataException {
		if (formatoTarga == null || formatoTarga.length() != 7) {
			throw new BadDataFormatException("The class doesn't gave the suitable standard format.");
		}
		char[] whereToCheck = targa.toCharArray();
		char[] kindaRegexp = formatoTarga.toCharArray();
		for (int i = 0; i < kindaRegexp.length; i++) {
			if (kindaRegexp[i] == 'L') {
				if (!Character.isAlphabetic(whereToCheck[i])) {
					throw new TargaErrataException("Excepted a letter on char " + i);
				}
			} else if (kindaRegexp[i] == 'N') {
				if (!Character.isDigit(whereToCheck[i])) {
					throw new TargaErrataException("Excepted a digit on char " + i);
				}
			} else {
				throw new BadDataFormatException("The class doesn't gave the suitable standard format.");
			}
		}
	}

}
