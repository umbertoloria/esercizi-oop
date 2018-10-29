package settimana5.esercizio1;

import settimana6.Measurable;

public class Coin implements Measurable {

	private String nome;
	private double valore;

	public Coin(String nome, double valore) {
		this.nome = nome;
		this.valore = valore;
	}

	public String getNome() {
		return nome;
	}

	public double getValore() {
		return valore;
	}

	public boolean equals(Coin moneta) {
		return nome.equals(moneta.getNome());
	}

	public String toString() {
		return "Coin[" + getNome() + " = " + getValore() + "]";
	}

	public double getMeasure() {
		return valore;
	}
}
