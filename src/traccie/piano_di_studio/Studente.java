package traccie.piano_di_studio;

import java.util.ArrayList;
import java.util.Iterator;

class Studente extends Account {

	private String matricola, piano;
	private ArrayList<Esame> esami = new ArrayList<>();

	Studente(String nome, String cognome, String matricola, String piano, String password) {
		super(nome, cognome, password);
		this.matricola = matricola;
		this.piano = piano;
	}

	void addEsame(Esame esame) {
		esami.add(esame);
	}

	void setEsame(String corso, int voto, String data, String docente) {
		for (Esame esame : esami) {
			if (esame.getCorso().equals(corso)) {
				esame.sostieni(voto, data, docente);
			}
		}
	}

	String getMatricola() {
		return matricola;
	}

	String getPiano() {
		return piano;
	}

	Object[][] getVoti() {
		Object[][] res = new Object[esami.size()][3];
		Iterator<Esame> it = esami.iterator();
		int i = 0;
		while (it.hasNext()) {
			res[i++] = it.next().getArray();
		}
		return res;
	}

	double getMedia() {
		if (esami.size() == 0) {
			return 0;
		}
		Iterator<Esame> it = esami.iterator();
		double media = it.next().getVoto();
		int i = 1;
		int tmp;
		while (it.hasNext()) {
			tmp = it.next().getVoto();
			if (tmp >= 18) {
				media += tmp;
				i++;
			}
		}
		return media / i;
	}

	boolean haSostenutoEsame(String corso) {
		for (Esame esame : esami) {
			if (esame.getCorso().equals(corso) && esame.sostenuto()) {
				return true;
			}
		}
		return false;
	}

}
