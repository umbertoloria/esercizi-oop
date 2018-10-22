package settimana3.esercizio2;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private List<int[]> voti = new ArrayList<>();

	public void newVoto(int voto, int cfu) {
		int[] vals = {voto, cfu};
		voti.add(vals);
	}

	public double getMedia() {
		double sum = 0;
		int cfus = 0;
		for (int[] dati : voti) {
			sum += dati[0] * dati[1];
			cfus += dati[1];
		}
		sum /= cfus;
		return sum;
	}


}
