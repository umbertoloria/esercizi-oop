package traccie.hotel.clienti;

import traccie.hotel.dati.Database;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Stanza {

	private int piano, numero;
	private String tipologia, telefono, servizi;
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<>();

	public Stanza(int piano, int numero, String tipologia, String telefono, String servizi) {
		this.piano = piano;
		this.numero = numero;
		this.tipologia = tipologia;
		this.telefono = telefono;
		this.servizi = servizi;
	}

	public boolean disponibile(GregorianCalendar checkin, GregorianCalendar checkout) {
		if (prenotazioni.isEmpty()) {
			return true;
		}
		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.finitaPrimaDi(checkin) && prenotazione.iniziataDopoDi(checkout)) {
				return true;
			}
		}
		return false;
	}

	public boolean is(String tipo) {
		return tipologia.equalsIgnoreCase(tipo);
	}

	public void prenota(GregorianCalendar checkin, GregorianCalendar checkout, Cliente cliente, boolean save) {
		Prenotazione prenotazione = new Prenotazione(checkin, checkout, cliente);
		prenotazioni.add(prenotazione);
		if (save) {
			Database.updateFile();
		}
	}

	public ArrayList<Prenotazione> getPrenotazioniANomeDi(String cognome, String nome) {
		ArrayList<Prenotazione> res = new ArrayList<>();
		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.intestataA(cognome, nome)) {
				res.add(prenotazione);
			}
		}
		return res;
	}

	public Prenotazione[] getPrenotazioni() {
		return prenotazioni.toArray(new Prenotazione[0]);
	}

	public int getPiano() {
		return piano;
	}

	public int getNumero() {
		return numero;
	}

	public String toString() {
		return "Piano " + piano + " - Numero " + numero + " - Tipo " + tipologia + " - Telefono " + telefono
				+ " - Servizi " + servizi;
	}

	public String toFileRow() {
		return piano + "\t" + numero + "\t" + tipologia + "\t" + telefono + "\t" + servizi;
	}

	public boolean locazione(int piano, int numero) {
		return this.piano == piano && this.numero == numero;
	}

	public void rimuoviPrenotazione(Prenotazione toremove) {
		prenotazioni.remove(toremove);
		Database.updateFile();
	}

}
