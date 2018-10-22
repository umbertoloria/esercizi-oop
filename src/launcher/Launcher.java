package launcher;

import settimana3.esercizio3.RegistratoreCassa;

public class Launcher {

	public static void main(String[] args) {
		RegistratoreCassa rc = new RegistratoreCassa();
		rc.acquisto(RegistratoreCassa.ACQUA_1L, 5, 10);
		rc.acquisto(RegistratoreCassa.COCACOLA_33ML, 2, 5);
		rc.print();
	}
}
