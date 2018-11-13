package traccie.domotica.launcher;

import traccie.domotica.elettrodomestici.Lavatrice;
import traccie.domotica.elettrodomestici.LettoreMP3;
import traccie.domotica.opzioni.Canzone;
import traccie.domotica.opzioni.Opzione;

import java.util.Random;

public class DomoticaTest {

	private static final Opzione[] programmi = {new Opzione("Lana"), new Opzione("Normale"), new Opzione("Seta"),
			new Opzione("Rapido")};

	public static final Canzone[] canzoni = {new Canzone("Bob Dylan", "Knocking on Heavens Door"),
			new Canzone("Led Zeppelin", "Stairway to Heaven"), new Canzone("Pink Floyd", "Money")};

	public static void main() {
		Domotica d = new Domotica();

		String[] nomi = {"Sam", "Jesse", "Carl", "Oscar", "Bradley"};
		String[] marche = {"Samsung", "LG", "Lenovo", "Toshiba"};

		Random r = new Random();
		String nome, marca;
		for (int i = 0; i < 20; i++) {
			nome = nomi[i % nomi.length];
			marca = marche[i / nomi.length];
			if (r.nextBoolean()) {
				d.aggiungiElettrodomestico(new Lavatrice(nome, marca, programmi));
			} else {
				d.aggiungiElettrodomestico(new LettoreMP3(nome, marca, canzoni));
			}
		}

		int elettrodomestici = d.getCount();

		int elett, opz;
		Opzione opzv;
		for (int i = 0; i < 100; i++) {

			elett = r.nextInt(elettrodomestici);
			opz = r.nextInt(programmi.length + canzoni.length);

			if (opz < programmi.length) {
				opzv = programmi[opz];
			} else {
				opzv = canzoni[opz - programmi.length];
			}

			if (d.eseguiProgramma(elett, opzv)) {
				System.out.printf("%-36s su %2d -> DONE\n", opzv, elett);
			} else {
				System.out.printf("%-36s su %2d -> FAIL\n", opzv, elett);
			}
		}

		d.stop();
		System.out.println("\n" + d);
	}

}
