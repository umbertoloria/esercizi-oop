package traccie.libreria;

public class Libro implements Comparable<Libro> {

	private String titolo, autore, editore;
	private int giacenza = 0;

	public Libro(String titolo, String autore, String editore, int giacenza) {
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.giacenza = giacenza;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public String getEditore() {
		return editore;
	}

	public int getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	public int compareTo(Libro o) {
		return giacenza - o.giacenza;
	}

	public void print() {
		System.out.println(titolo);
		System.out.println(autore);
		System.out.println(editore);
		System.out.println(giacenza + "\n");
	}
}
