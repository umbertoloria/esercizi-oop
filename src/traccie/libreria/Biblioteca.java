package traccie.libreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Biblioteca {

	private String filePath;
	private TreeSet<Libro> libri = new TreeSet<>();

	public Biblioteca(String filePath) throws RuntimeException {
		this.filePath = filePath;
		Scanner a;
		try {
			a = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Impossibile leggere il file " + filePath);
		}
		ArrayList<String> lines = new ArrayList<>();
		while (a.hasNextLine()) {
			lines.add(a.nextLine());
		}
		a.close();
		int giacenza = 0;
		for (int i = 0; i < lines.size() - 3; i += 4) {
			try {
				giacenza = Integer.parseInt(lines.get(i + 3));
			} catch (NumberFormatException e) {
				System.err.println("File non corretto.");
				System.exit(1);
			}
			libri.add(new Libro(lines.get(i), lines.get(i + 1), lines.get(i + 2), giacenza));
		}
	}

	public Libro[] getLibriOf(String autore) {
		ArrayList<Libro> res = new ArrayList<>();
		for (Libro libro : libri) {
			if (libro.getAutore().equals(autore)) {
				res.add(libro);
			}
		}
		return res.toArray(new Libro[0]);
	}

	public Libro[] getLibriLike(String ago) {
		ArrayList<Libro> res = new ArrayList<>();
		ago = ago.toLowerCase();
		for (Libro libro : libri) {
			if (libro.getTitolo().toLowerCase().contains(ago)) {
				res.add(libro);
			}
		}
		return res.toArray(new Libro[0]);
	}

	public Libro getMax() {
		return libri.last();
	}

	public Libro[] getLessThen(int level) {
		//return libri.headSet(new Libro("", "", "", level), false).toArray(new Libro[0]);
		ArrayList<Libro> res = new ArrayList<>();
		for (Libro libro : libri) {
			if (libro.getGiacenza() >= level) {
				break;
			}
			res.add(libro);
		}
		return res.toArray(new Libro[0]);
	}

	// N.B.: Il programma salva i libri in maniera ordinata (non come erano).
	private void save() throws RuntimeException {
		PrintStream ps;
		try {
			ps = new PrintStream(filePath);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Impossibile salvare su " + filePath);
		}
		for (Libro libro : libri) {
			ps.println(libro.getTitolo());
			ps.println(libro.getAutore());
			ps.println(libro.getEditore());
			ps.println(libro.getGiacenza());
		}
		ps.flush();
		ps.close();
	}

	// N.B.: Assumendo che non ci possano essere più libri con lo stesso titolo
	public void updateGiacenzaOf(String titolo, int nuovaGiacenza) {
		for (Libro libro : libri) {
			if (libro.getTitolo().equals(titolo)) {
				libro.setGiacenza(nuovaGiacenza);
				break;
			}
		}
	}

	public static void main() {
		Biblioteca bt = new Biblioteca("libri.txt");
		Libro[] l = bt.getLessThen(33);
		for (Libro libro : l) {
			libro.print();
		}
		bt.updateGiacenzaOf("Sogni rossi", 15);
		bt.save();
	}

}
