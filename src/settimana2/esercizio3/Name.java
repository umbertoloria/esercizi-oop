package settimana2.esercizio3;

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

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getInitials() {
		return initials;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public String getCompleteName() {
		return completeName;
	}

	public String getSurName() {
		return surName;
	}

	public int getTitolo() {
		return titolo;
	}

	public String getTitoloString() {
		return titoli[titolo];
	}

	public void print() {
		System.out.println("Nome:          " + getName());
		System.out.println("Cognome:       " + getSurname());
		System.out.println("Titolo:        " + getTitoloString());
		System.out.println("Iniziali:      " + getInitials());
		System.out.println("Nome Cognome:  " + getNameSurname());
		System.out.println("Cognome Nome:  " + getSurName());
		System.out.println("Nome completo: " + getCompleteName());
	}

}
