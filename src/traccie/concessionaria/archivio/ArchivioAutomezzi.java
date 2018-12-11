package traccie.concessionaria.archivio;

import traccie.concessionaria.exceptions.TargaErrataException;
import traccie.concessionaria.mezzi.Automezzo;
import traccie.concessionaria.mezzi.Autoveicolo;
import traccie.concessionaria.mezzi.Motociclo;

import java.io.*;
import java.util.ArrayList;

/* I metodi e gli attributi statici non verranno serializzati. */
public class ArchivioAutomezzi implements Serializable {

	private static final long serialVersionUID = 1000100010001000100L;
	private static String filepath;
	private static ArchivioAutomezzi aa;

	static void readFile(String file) {
		filepath = file;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filepath));
		} catch (IOException e) {
			System.exit(1);
		}
		try {
			aa = (ArchivioAutomezzi) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Impossibile aprire il file.");
			System.exit(1);
		}
	}

	static void writeFile(String filepath) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filepath));
		} catch (IOException e) {
			System.exit(0);
		}
		ArchivioAutomezzi aa = new ArchivioAutomezzi();
		try {
			aa.add(new Autoveicolo("Toyota", "Rav 4", "AC214CD", 2006, "Diesel", 5, 6));
			aa.add(new Autoveicolo("Ford", "Focus", "EF504AB", 2013, "Benzina", 5, 5));
			aa.add(new Autoveicolo("Lancia", "Ypsilon", "EF401VF", 2012, "Benzina", 5, 5));
			aa.add(new Motociclo("Honda", "Hornet", "CD65430", 2012, 2, 2));
			aa.add(new Motociclo("Honda", "Transalph", "FL51230", 2006, 2, 2));
		} catch (TargaErrataException e1) {
		}
		try {
			oos.writeObject(aa);
			oos.close();
		} catch (IOException e) {
		}
		System.exit(0);
	}

	private static boolean save() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filepath));
		} catch (IOException e) {
			return false;
		}
		try {
			oos.writeObject(aa);
			oos.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	private ArrayList<Automezzo> veicoli = new ArrayList<>();

	public void add(Automezzo veicolo) {
		veicoli.add(veicolo);
	}

	public static void inserisci(Automezzo veicolo) {
		aa.add(veicolo);
		save();
	}

	public static Autoveicolo[] getAutoveicoliWith(String alimentazione, int numeroPosti) {
		ArrayList<Autoveicolo> res = new ArrayList<>();
		Automezzo mezzo;
		Autoveicolo veicolo;
		for (int i = 0; i < aa.veicoli.size(); i++) {
			mezzo = aa.veicoli.get(i);
			if (!(mezzo instanceof Autoveicolo)) {
				continue;
			}
			veicolo = (Autoveicolo) mezzo;
			if (!alimentazione.isEmpty() && !veicolo.getAlimentazione().equals(alimentazione)) {
				continue;
			}
			if (numeroPosti > 0 && veicolo.getNumeroPosti() != numeroPosti) {
				continue;
			}
			res.add(veicolo);
		}
		return res.toArray(new Autoveicolo[0]);
	}

	public static Autoveicolo[] getAutoveicoliWith(String targa) {
		ArrayList<Autoveicolo> res = new ArrayList<>();
		Automezzo mezzo;
		Autoveicolo veicolo;
		for (int i = 0; i < aa.veicoli.size(); i++) {
			mezzo = aa.veicoli.get(i);
			if (mezzo instanceof Autoveicolo) {
				veicolo = (Autoveicolo) mezzo;
				if (mezzo.getTarga().equals(targa)) {
					res.add(veicolo);
				}
			}
		}
		return res.toArray(new Autoveicolo[0]);
	}

	public static Motociclo[] getMotocicliWith(int anno, int numeroRuote) {
		ArrayList<Motociclo> res = new ArrayList<>();
		Automezzo mezzo;
		Motociclo moto;
		for (int i = 0; i < aa.veicoli.size(); i++) {
			mezzo = aa.veicoli.get(i);
			if (!(mezzo instanceof Motociclo)) {
				continue;
			}
			moto = (Motociclo) mezzo;
			if (anno > 0 && mezzo.getAnno() != anno) {
				continue;
			}
			if (numeroRuote > 0 && moto.getNumeroRuote() != numeroRuote) {
				continue;
			}
			res.add(moto);
		}
		return res.toArray(new Motociclo[0]);
	}

	public static Motociclo[] getMotocicliWith(String targa) {
		ArrayList<Motociclo> res = new ArrayList<>();
		Automezzo mezzo;
		Motociclo moto;
		for (int i = 0; i < aa.veicoli.size(); i++) {
			mezzo = aa.veicoli.get(i);
			if (mezzo instanceof Motociclo) {
				moto = (Motociclo) mezzo;
				if (mezzo.getTarga().equals(targa)) {
					res.add(moto);
				}
			}
		}
		return res.toArray(new Motociclo[0]);
	}

}
