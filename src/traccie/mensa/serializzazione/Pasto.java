package traccie.mensa.serializzazione;

import java.io.Serializable;
import java.util.ArrayList;

public class Pasto implements Serializable {

	private static final long serialVersionUID = 1000000002L;
	private ArrayList<Piatto> piatti = new ArrayList<>();

	public Pasto(ArrayList<Piatto> piatti) {
		for (Piatto piatto : piatti) {
			this.piatti.add(piatto);
		}
	}

	float getCosto() {
		float costo = 0;
		for (Piatto piatto : piatti) {
			costo += piatto.getCosto();
		}
		return costo;
	}

}
