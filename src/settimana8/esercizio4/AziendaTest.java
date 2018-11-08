package settimana8.esercizio4;

import java.util.Random;
import java.util.Scanner;

public class AziendaTest {

	public static void main() {

		String[] nomi = {"Adam", "Matthew", "Jim", "John", "Zachary"};
		String[] cognomi = {"McDonalds", "BurgerKings", "KennedyFC", "Nandos"};

		Lavoratore[] lavoratori = new Lavoratore[nomi.length * cognomi.length];

		String nome, cognome;
		double pagaOraria;
		int oreDilavoro;
		Scanner in = new Scanner(System.in);
		Random r = new Random();


		for (int i = 0; i < lavoratori.length; i++) {
			nome = nomi[i % nomi.length];
			cognome = cognomi[i / nomi.length];
			pagaOraria = 10 + r.nextInt(8);
			while (true) {
				try {
					System.out.println("Fornisci le ore di lavoro eseguite da " + nome + " " + cognome + ": ");
					oreDilavoro = Integer.parseInt(in.nextLine());
					break;
				} catch (java.lang.NumberFormatException e) {
					System.err.println("Fornire un numero valido.\n");
				}
			}
			if (r.nextBoolean()) {
				lavoratori[i] = new Lavoratore(nome, cognome, pagaOraria);
			} else {
				lavoratori[i] = new LavoratoreFisso(nome, cognome, pagaOraria);
			}
			lavoratori[i].setOreDiLavoro(oreDilavoro);
		}

		for (Lavoratore lav : lavoratori) {
			System.out.println("Lavoratore con retribuzione " + (lav instanceof LavoratoreFisso ? "fissa" : "ad ore"));
			System.out.println("Nome completo: " + lav.getNome() + " " + lav.getCognome());
			System.out.println("Ore di lavoro: " + lav.getOreDiLavoro());
			System.out.println("Paga oraria  : " + lav.getPagaOraria());
			System.out.println("Paga totale  : " + lav.getPaga() + "\n");
			double oracle;
			if (lav instanceof LavoratoreFisso) {
				oracle = lav.getPagaOraria() * 40;
			} else {
				if (lav.getOreDiLavoro() > 40) {
					oracle = lav.getPagaOraria() * 40 + lav.getPagaOraria() * (lav.getOreDiLavoro() - 40) * 1.5;
				} else {
					oracle = lav.getPagaOraria() * lav.getOreDiLavoro();
				}
			}
			if (oracle != lav.getPaga()) {
				System.err.println("Problema con " + lav.getNome() + " " + lav.getCognome() + "!");
			}
		}

	}

}
