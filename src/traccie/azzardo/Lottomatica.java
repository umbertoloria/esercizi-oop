package traccie.azzardo;

public class Lottomatica {

	public static void main() {
		Cliente c = new Cliente("LROMRT222", 18);
		for (int i = 0; i < 10; i++) {
			c.giocaPartita();
		}
		System.out.println("SALDO INIZIALE : " + c.getSaldo());
		System.out.println("SALDO FINALE   : " + c.getSaldoIniziale());
	}

	static void printArray(int[] estratti) {
		System.out.print("[");
		for (int i = 0; i < estratti.length - 1; i++) {
			System.out.printf("%2d, ", estratti[i]);
		}
		System.out.printf("%2d]\n", estratti[estratti.length - 1]);
	}

}
