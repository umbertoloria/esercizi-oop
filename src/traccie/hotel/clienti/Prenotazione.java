package traccie.hotel.clienti;

import traccie.hotel.dati.DateUtils;

import java.util.GregorianCalendar;

public class Prenotazione implements Comparable<Prenotazione> {

	private GregorianCalendar checkin, checkout;
	private Cliente cliente;

	Prenotazione(GregorianCalendar checkin, GregorianCalendar checkout, Cliente cliente) {
		if (checkin.compareTo(checkout) >= 0 || cliente == null) {
			System.out.println(DateUtils.display(checkin));
			System.out.println(DateUtils.display(checkout));
			throw new RuntimeException("Prenotazione invalida.");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		this.cliente = cliente;
	}

	public int compareTo(Prenotazione o) {
		return checkin.compareTo(checkout);
	}

	boolean finitaPrimaDi(GregorianCalendar date) {
		return checkout.compareTo(date) < 0;
	}

	boolean iniziataDopoDi(GregorianCalendar date) {
		return checkin.compareTo(date) > 0;
	}

	boolean intestataA(String cognome, String nome) {
		return cliente.getNomeCompleto().equalsIgnoreCase(cognome + " " + nome);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public GregorianCalendar getCheckin() {
		return checkin;
	}

	public GregorianCalendar getCheckout() {
		return checkout;
	}

	public String toFileRow() {
		return DateUtils.display(checkin) + "\t" + DateUtils.display(checkout) + "\t" + cliente.toFileRow();
	}

}
