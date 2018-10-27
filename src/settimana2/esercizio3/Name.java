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
	 Gets the name of a person.
	 @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 Gets the surname of a person.
	 @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 Gets the initials of a person.
	 @return initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 Gets the name and surname of a person.
	 @return name and surname (separated by a coma)
	 */
	public String getNameSurname() {
		return nameSurname;
	}

	/**
	 Gets the surname and name of a person.
	 @return surname and name (separated by a coma)
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 Gets the complete name of a person.
	 @return complete name
	 */
	public String getCompleteName() {
		return completeName;
	}

	/**
	 Gets the title of a person.
	 @return the title (memorized by numeric values)
	 @see Name
	 */
	public int getTitolo() {
		return titolo;
	}

	/**
	 Gets the title of a person.
	 @return the title (like Signora, Signore, Signorina)
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
