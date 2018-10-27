package settimana5.esercizio3;

public class ModelloAuto {

	private String marca;
	private String modello;
	private int immatricolazione;
	private double prezzo;

	public ModelloAuto(String marca, String modello, int immatricolazione, double prezzo) {
		this.marca = marca;
		this.modello = modello;
		this.immatricolazione = immatricolazione;
		this.prezzo = prezzo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getImmatricolazione() {
		return immatricolazione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String toString() {
		return "ModelloAuto[" + marca + ", " + modello + ", " + immatricolazione + ", " + prezzo + "]";
	}

}
