package traccie.domotica.launcher;

import traccie.domotica.elettrodomestici.Elettrodomestico;
import traccie.domotica.elettrodomestici.LettoreMP3;
import traccie.domotica.opzioni.Opzione;

import java.util.LinkedList;

public class Domotica {

	private LinkedList<Elettrodomestico> elettrodomestici = new LinkedList<>();

	public void aggiungiElettrodomestico(Elettrodomestico e) {
		elettrodomestici.add(e);
	}

	public boolean eseguiProgramma(int i, Opzione j) {
		Elettrodomestico e = elettrodomestici.get(i);
		Opzione elem = new Opzione("");
		int ind = 0;
		if (!e.acceso()) {
			if (e instanceof LettoreMP3) {
				((LettoreMP3) e).load();
			}
			elem = (Opzione) e.start();
			ind++;
		}
		while (ind < e.getCount() + 1 && !elem.equals(j)) {
			elem = (Opzione) e.next();
			ind++;
		}
		if (ind < e.getCount() + 1) {
			e.play();
			return true;
		}
		return false;
	}

	public void stop() {
		for (Elettrodomestico<?> e : elettrodomestici) {
			e.stop();
		}
	}

	public int getCount() {
		return elettrodomestici.size();
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(getClass().getName());
		str.append(" {\n");
		for (int i = 0; i < elettrodomestici.size() - 1; i++) {
			str.append("\t");
			str.append(i);
			str.append(" -> ");
			str.append(elettrodomestici.get(i));
			str.append(",\n");
		}
		str.append("\t");
		str.append(elettrodomestici.size() - 1);
		str.append(" -> ");
		str.append(elettrodomestici.get(elettrodomestici.size() - 1));
		str.append("\n}");
		return str.toString();
	}

}
