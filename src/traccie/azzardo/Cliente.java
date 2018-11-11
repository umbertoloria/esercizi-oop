package traccie.azzardo;

import java.util.Random;

class Cliente {

	private String codiceFiscale;
	private double saldo, saldoIniziale;
	private int partite = 0;
	private CartaAlta ca = new CartaAlta(2.5);
	private Ambata a = new Ambata(1.5);

	Cliente(String codiceFiscale, double saldo) {
		this.codiceFiscale = codiceFiscale;
		this.saldo = saldo;
		this.saldoIniziale = saldo;
	}

	void giocaPartita() {
		if (saldo > 0) {
			System.out.println("GIOCO NUMERO " + (partite + 1));
			Gioco gioco = new Random().nextBoolean() ? ca : a;
			saldo -= gioco.getCosto();
			double vittoria = gioco.gioca() ? gioco.dammiVincita() : 0;
			saldo += vittoria;
			System.out.printf("Saldo: %.2f (", saldo);
			if (vittoria > 0) {
				System.out.printf("+%.2f", vittoria);
			} else {
				System.out.printf("-%.2f", gioco.getCosto());
			}
			System.out.println(")\n");
			partite++;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public double getSaldoIniziale() {
		return saldoIniziale;
	}

	public String toString() {
		return getClass().getName() + "[codiceFiscale="
				+ codiceFiscale + ",saldo=" + saldo + "]";
	}

}
