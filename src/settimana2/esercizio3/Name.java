package settimana2.esercizio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Name {

	public static final int SIGNORA = 0;
	public static final int SIGNORE = 1;
	public static final int SIGNORINA = 2;

	private static final String[] titoli = {"Signora", "Signore", "Signorina"};

	private String name, surname;
	private int titolo;
	private String initials;
	private String nameSurname;
	private String surName;
	private String completeName;

	/**
	 * @param name    Nome della persona di riferimento.
	 * @param surname Cognome della persona di riferimento.
	 * @param titolo  Può essere Signora, Signore o Signorina.
	 * @see Name
	 */
	public Name(String name, String surname, int titolo) {
		this.name = name;
		this.surname = surname;
		this.titolo = titolo;
		init();
	}

	private void init() {
		initials = (name.charAt(0) + "").toUpperCase() + (surname.charAt(0) + "").toUpperCase();
		nameSurname = name + ", " + surname;
		surName = surname + ", " + name;
		completeName = titoli[titolo] + " " + name + " " + surname;
	}

	/**
	 * @return Nome memorizzato.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Cognome memorizzato.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return Iniziali del nome e cognome.
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * @return Nome e cognome separati da una virgola.
	 */
	public String getNameSurname() {
		return nameSurname;
	}

	/**
	 * @return Cognome e nome separati da una virgola.
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @return Nome completo.
	 */
	public String getCompleteName() {
		return completeName;
	}

	/**
	 * @return Il titolo memorizzato in valori numerici.
	 * @see Name
	 */
	public int getTitolo() {
		return titolo;
	}

	/**
	 * @return Il titolo memorizzato (Signora, Signore, Signorina).
	 */
	public String getTitoloString() {
		return titoli[titolo];
	}

	public void print() {
		System.out.println("Nome:          " + getName());
		System.out.println("Cognome:       " + getSurname());
		System.out.println("Titolo:        " + getTitoloString());
		System.out.println("Iniziali:      " + getInitials());
		System.out.println("Nome cognome:  " + getNameSurname());
		System.out.println("Cognome nome:  " + getSurName());
		System.out.println("Nome completo: " + getCompleteName());
	}

	public void print(PrintStream out) {
		out.println("Nome:          " + getName());
		out.println("Cognome:       " + getSurname());
		out.println("Titolo:        " + getTitoloString());
		out.println("Iniziali:      " + getInitials());
		out.println("Nome cognome:  " + getNameSurname());
		out.println("Cognome nome:  " + getSurName());
		out.println("Nome completo: " + getCompleteName());
	}

	public static void main() {
		Name a = new Name("Umberto", "Loria", Name.SIGNORE);
		File file = new File("name.log");
		try (PrintStream out = new PrintStream(file)) {
			a.print(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
