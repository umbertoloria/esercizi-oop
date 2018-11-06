package settimana7.esercizio1;

import banking.BankAccount;
import settimana6.DataSet;
import settimana6.Measurable;

import java.util.Random;
import java.util.Scanner;

public class Quiz implements Measurable {

	private char[] voti = new char[]{'E', 'D', 'C', 'B', 'A'};
	private double punteggio;

	public Quiz(double punteggio) {
		/*QuizDomanda a = new QuizDomanda("Di che colore è il cavallo bianco di Napoleone?", "bianco", "marrone", "grigio", "nero");
		a.ask();*/
		this.punteggio = punteggio;
	}

	public double getMeasure() {
		return punteggio;
	}

	public String getVoto() {
		double tmp = punteggio / 2;
		String res = voti[(int) tmp - 1] + "";
		if (tmp - (int) tmp >= .5) {
			res += "+";
		} else {
			System.err.println(tmp);
		}
		return res;

	}

	public static void main () {
		DataSet a = new DataSet();
		a.add(new Quiz(9.2));
		a.add(new Quiz(5));
		a.add(new Quiz(4));
		a.add(new Quiz(4));
		double av = a.getAverage();
		System.out.println(av);

		try {
			Quiz max = (Quiz) a.getMax();
			System.out.println(max.getVoto());
		} catch (ClassCastException e) {
			System.err.println("Problema!");
		}
	}

	class QuizDomanda {

		private String domanda;
		private String[] risposte = new String[4];
		private Random r = new Random();

		public QuizDomanda(String domanda, String vera, String f1, String f2, String f3) {
			this.domanda = domanda;
			this.risposte[0] = vera;
			this.risposte[1] = f1;
			this.risposte[2] = f2;
			this.risposte[3] = f3;
		}

		public void ask() {
			int[] ordine = new int[]{0, 1, 2, 3};
			for (int i = 0; i < 5; i++) {
				int f = r.nextInt(4);
				int s = r.nextInt(4);
				while (s == f) {
					s = r.nextInt(4);
				}
				int tmp = ordine[f];
				ordine[f] = ordine[s];
				ordine[s] = tmp;
			}
			System.out.println(domanda);
			for (int i = 0; i < ordine.length; i++) {
				System.out.println((char) ('A' + i) + ": " + risposte[ordine[i]]);
			}
			System.out.println("Qual'è la tua risposta? [A-D]");
			Scanner in = new Scanner(System.in);
			String risp = in.nextLine().trim();
			int indexRisp = -1;
			if (risp.equalsIgnoreCase("a")) {
				indexRisp = 0;
			} else if (risp.equalsIgnoreCase("b")) {
				indexRisp = 1;
			} else if (risp.equalsIgnoreCase("c")) {
				indexRisp = 2;
			} else if (risp.equalsIgnoreCase("d")) {
				indexRisp = 3;
			} else {
				System.out.println("Risposta non valida.");
			}
			if (ordine[indexRisp] == 0) {
				System.out.println("giusta");
			} else {
				System.out.println("sbagliato");
			}
		}

	}

}