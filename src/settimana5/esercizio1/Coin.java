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

	boolean equals(Coin moneta) {
		return nome.equals(moneta.getNome());
	}

	public String toString() {
		return "Coin[" + getNome() + " = " + getValore() + "]";
	}

	public double getMeasure() {
		return valore;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			return nome.equals(((Coin) obj).nome) && valore == ((Coin) obj).valore;
		}
		return false;
	}
}
