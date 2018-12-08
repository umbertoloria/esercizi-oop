package traccie.hotel.dati;

import traccie.hotel.clienti.Cliente;
import traccie.hotel.clienti.Prenotazione;
import traccie.hotel.clienti.Stanza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Database {

	private static ArrayList<Stanza> stanze = new ArrayList<>();
	private static File file;

	public static void init(File f) {
		file = f;
		Scanner sc;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			return;
		}
		String line;
		String[] app;
		int piano, numero;
		String tipo;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			if (line.equals("PRENOTAZIONI")) {
				break;
			}
			app = line.split("\t");
			piano = Integer.parseInt(app[0]);
			numero = Integer.parseInt(app[1]);
			tipo = app[2];
			if (!tipo.equals("singola") && !tipo.equals("doppia") && !tipo.equals("matrimoniale")) {
				System.err.println("File malformato.");
				System.exit(1);
			}
			stanze.add(new Stanza(piano, numero, tipo, app[3], app[4]));
		}
		GregorianCalendar checkin, checkout;
		Cliente cliente;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			app = line.split("\t");
			piano = Integer.parseInt(app[0]);
			numero = Integer.parseInt(app[1]);
			checkin = DateUtils.getFrom(app[2]);
			checkout = DateUtils.getFrom(app[3]);
			cliente = new Cliente(app[4], app[5], app[6], app[7]);
			for (Stanza stanza : stanze) {
				if (stanza.locazione(piano, numero)) {
					stanza.prenota(checkin, checkout, cliente, false);
				}
			}
		}
		sc.close();
	}

	public static Stanza[] getStanzeDisponibili(GregorianCalendar checkin, GregorianCalendar checkout, String tipo) {
		ArrayList<Stanza> res = new ArrayList<>();
		for (Stanza stanza : stanze) {
			if (stanza.is(tipo) && stanza.disponibile(checkin, checkout)) {
				res.add(stanza);
			}
		}
		return res.toArray(new Stanza[0]);
	}

	public static Prenotazione[] getPrenotazioniDi(String cognome, String nome) {
		ArrayList<Prenotazione> res = new ArrayList<>();
		for (Stanza stanza : stanze) {
			res.addAll(stanza.getPrenotazioniANomeDi(cognome, nome));
		}
		return res.toArray(new Prenotazione[0]);
	}

	public static void updateFile() {
		PrintStream ps;
		try {
			ps = new PrintStream(file);
		} catch (FileNotFoundException e) {
			return;
		}
		for (Stanza stanza : stanze) {
			ps.println(stanza.toFileRow());
		}
		ps.println("PRENOTAZIONI");
		for (Stanza stanza : stanze) {
			Prenotazione[] prenotazioni = stanza.getPrenotazioni();
			for (Prenotazione prenotazione : prenotazioni) {
				ps.println(stanza.getPiano() + "\t" + stanza.getNumero() + "\t" + prenotazione.toFileRow());
			}
		}
		ps.flush();
		ps.close();
	}

	public static void rimuovi(Prenotazione prenotazione) {
		for (Stanza stanza : stanze) {
			stanza.rimuoviPrenotazione(prenotazione);
		}
	}

}
