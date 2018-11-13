package traccie.domotica.elettrodomestici;

import traccie.domotica.opzioni.Opzione;

public class Lavatrice extends Elettrodomestico<Opzione> {

	private int direction = 1;

	public Lavatrice(String nome, String marca, Opzione[] programmi) {
		super(nome, marca);
		load(programmi);
	}

	public int avanza(int lastIndex) {
		if (direction > 0 && getIndex() == getCount() - 1) {
			direction = -direction;
		} else if (direction < 0 && getIndex() == 0) {
			direction = -direction;
		}
		return lastIndex + direction;
	}

}
