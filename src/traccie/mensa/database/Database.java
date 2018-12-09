package traccie.mensa.database;

import traccie.mensa.serializzazione.Cliente;
import traccie.mensa.serializzazione.Piatto;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class Database {

	private static final Hashtable<String, Cliente> clienti = new Hashtable<>();
	private static Piatto[] piatti;
	private static String filepath;

	public static void init(String path) {
		filepath = path;
		ArrayList<Piatto> tmp = new ArrayList<>();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(filepath));
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}
		try {
			Object app;
			while (true) {
				app = ois.readObject();
				if (app instanceof Piatto) {
					tmp.add((Piatto) app);
				} else if (app instanceof Cliente) {
					clienti.put(((Cliente) app).getUsername(), (Cliente) app);
				} else {
					System.err.println("File invalido.");
					System.exit(1);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
		}
		piatti = tmp.toArray(new Piatto[0]);
		try {
			ois.close();
		} catch (IOException e1) {
		}
	}

	public static Cliente login(String username, String password) {
		Cliente c = clienti.get(username);
		return c != null && c.checkPassword(password) ? c : null;
	}

	public static Piatto[] getPiatti() {
		return piatti;
	}

	public static void loadData() {
		ArrayList<Object> dati = new ArrayList<>();
		dati.add(new Piatto("Pasta al sugo", 449, 2.5f));
		dati.add(new Piatto("Risotto alla pescatora", 345, 4f));
		dati.add(new Piatto("Pasta e lenticchie", 230, 3.5f));
		dati.add(new Piatto("Carne alla griglia", 260, 5.5f));
		dati.add(new Piatto("Pesce al vapore", 210, 6.5f));
		dati.add(new Piatto("Mozzarella", 180, 5f));
		dati.add(new Piatto("Insalata", 60, 2f));
		dati.add(new Cliente("uloria", "pwd", "Loria", "Umberto", 120f));
		dati.add(new Cliente("anapoli", "pwd", "Napoli", "Antonio", 80f));
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("clienti.dat"));
		} catch (IOException e) {
			return;
		}
		try {
			for (Object obj : dati) {
				oos.writeObject(obj);
			}
			oos.close();
		} catch (IOException e) {
			return;
		}
		System.exit(1);
	}

	public static void save() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filepath));
		} catch (IOException e) {
			return;
		}
		try {
			for (Piatto piatto : piatti) {
				oos.writeObject(piatto);
			}
			Iterator<Cliente> it = clienti.elements().asIterator();
			while (it.hasNext()) {
				oos.writeObject(it.next());
			}
			oos.close();
		} catch (IOException e) {
		}
	}

}
