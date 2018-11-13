package traccie.domotica.elettrodomestici;

import traccie.domotica.opzioni.Canzone;

public class LettoreMP3 extends Elettrodomestico<Canzone> {

	private Canzone[] canzoni;

	public LettoreMP3(String nome, String marca, Canzone[] canzoni) {
		super(nome, marca);
		this.canzoni = canzoni;
	}

	public void load() {
		super.load(canzoni);
	}

	public int avanza(int lastIndex) {
		return (lastIndex + 1) % getCount();
	}

}
