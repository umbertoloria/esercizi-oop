package traccie.piano_di_studio;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

class Database {

	private static Hashtable<String, Account> utenti = new Hashtable<>();

	static String getNomeCompleto(String username) {
		Account a = utenti.get(username);
		return a != null ? a.getNomeCompleto() : null;
	}

	static boolean register(String username, Account a) {
		if (utenti.get(username) == null) {
			utenti.put(username, a);
			return true;
		}
		return false;
	}

	static final int STUDENTE = 1;
	static final int PROFESSORE = 2;

	static int login(String username, String password) {
		Account a = utenti.get(username);
		boolean res = a != null && a.checkPassword(password);
		if (!res) {
			return 0;
		}
		if (a instanceof Studente) {
			return STUDENTE;
		}
		return PROFESSORE;
	}

	static Studente[] getStudentiSenzaEsame(String corso) {
		if (utenti.size() == 0) {
			return null;
		}
		ArrayList<Studente> studenti = new ArrayList<>();
		Iterator<Account> it = utenti.elements().asIterator();
		Account app;
		while (it.hasNext()) {
			app = it.next();
			if (app instanceof Studente) {
				if (!((Studente) app).haSostenutoEsame(corso)) {
					studenti.add((Studente) app);
				}
			}
		}
		return studenti.toArray(new Studente[0]);
	}

	static Object[][] getVotiAbout(String username) {
		Account a = utenti.get(username);
		if (a instanceof Studente) {
			return ((Studente) a).getVoti();
		}
		return new Object[][]{};
	}

	static double getMediaVoti(String username) {
		Account a = utenti.get(username);
		if (a instanceof Studente) {
			return ((Studente) a).getMedia();
		}
		return 0;
	}

	static void addEsame(String matricola, String docente, String corso, int voto) {
		Iterator<Account> it = utenti.elements().asIterator();
		Account app;
		Studente appS;
		while (it.hasNext()) {
			app = it.next();
			if (app instanceof Studente) {
				appS = (Studente) app;
				if (appS.getMatricola().equals(matricola)) {
					appS.setEsame(corso, voto, "oggi", docente);
				}
			}
		}
	}

	static String getCorso(String nome) {
		Account a = utenti.get(nome);
		if (a instanceof Professore) {
			return ((Professore) a).getCorso();
		}
		return null;
	}

	static String getPiano(String username) {
		Account a = utenti.get(username);
		if (a instanceof Studente) {
			return ((Studente) a).getPiano();
		}
		return null;
	}

}
