package settimana11.esercizio2;

import java.text.NumberFormat;
import java.util.Scanner;

public class NumberInputsTest {

	public static void main() {
		System.out.print("Length:  ");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		float[] dati = new float[n];
		float app;
		int attempts = 1;
		for (int i = 0; i < n; i++) {
			System.out.print("Fornisci numero " + (i + 1));
			System.out.print(attempts > 0 ? " (tentativi: " + attempts + "): " : ": ");
			try {
				dati[i] = Float.parseFloat(sc.nextLine());
				attempts = 0;
			} catch (NumberFormatException e) {
				System.err.println("Riprova...");
				i--;
				attempts++;
				if (attempts > 3) {
					System.out.println("Troppi tentativi.");
					System.exit(1);
				}
			}
		}

		System.out.println("Perfetto. Ecco l'array: ");
		for (int i = 0; i < dati.length; i++) {
			System.out.println("[" + i + "]: " + dati[i]);
		}
	}

}
