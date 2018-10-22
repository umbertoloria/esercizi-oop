package settimana3.esercizio3;

public class RegistratoreCassa {

	public static final int ACQUA_1L = 0;
	public static final int COCACOLA_33ML = 1;

	private static final double ACQUA_1L_PREZZO = 0.24;
	private static final double COCACOLA_33ML_PREZZO = 0.8;

	private int[] acquisti = new int[]{0, 0};

	public double acquisto(int prodotto, int quantità, double soldi) {
		if (prodotto != ACQUA_1L && prodotto != COCACOLA_33ML) {
			return -1;
		}
		if (quantità < 1) {
			return -1;
		}
		double resto = soldi - prodotto * quantità;
		if (resto < 0) {
			System.out.println("Devi darmi altri soldi!");
			return -1;
		}
		acquisti[prodotto] += quantità;
		return resto;
	}

	public void print() {
		System.out.println(".:STATUS:.");
		System.out.println("Acqua 1l      : " + acquisti[ACQUA_1L] + " (" + acquisti[ACQUA_1L] * ACQUA_1L_PREZZO + ")");
		System.out.println("Coca cola 33ml: " + acquisti[COCACOLA_33ML] + " (" + acquisti[COCACOLA_33ML] * COCACOLA_33ML_PREZZO + ")");
	}

}
