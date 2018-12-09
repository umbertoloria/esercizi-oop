package traccie.mensa.serializzazione;

import java.io.Serializable;

public class Piatto implements Serializable {

	private static final long serialVersionUID = 1000000003L;
	private String nome;
	private int kcal;
	private float costo;

	public Piatto(String nome, int kcal, float costo) {
		this.nome = nome;
		this.kcal = kcal;
		this.costo = costo;
	}

	public float getCosto() {
		return costo;
	}

	public int getKcal() {
		return kcal;
	}

	public String toString() {
		return nome + " - Euro " + costo;
	}

}
