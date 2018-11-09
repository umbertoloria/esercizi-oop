package traccie.azzardo;

import java.util.Random;

public abstract class Gioco {

	private Random r = new Random();
	private double costo;

	Gioco(double costo) {
		this.costo = costo;
	}

	int genera() {
		return 1 + r.nextInt(45);
	}

	double getCosto() {
		return costo;
	}

	public abstract boolean gioca();

	public abstract double dammiVincita();

	public abstract String toString();

}
