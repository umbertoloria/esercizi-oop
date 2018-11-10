package settimana5.esercizio1;

import settimana6.Measurable;

public class Coin implements Measurable, Cloneable {

	private String nome;
	private double valore;

	Coin(String nome, double valore) {
		this.nome = nome;
		this.valore = valore;
	}

	String getNome() {
		return nome;
	}

	double getValore() {
		return valore;
	}

	public String toString() {
		return "Coin[" + getNome() + " = " + getValore() + "]";
	}

	public double getMeasure() {
		return valore;
	}

	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Coin moneta = (Coin) obj;
			return nome.equals(moneta.nome) && valore == moneta.valore;
		}
		return false;
	}
}
