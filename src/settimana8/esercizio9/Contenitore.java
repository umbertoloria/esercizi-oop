package settimana8.esercizio9;

public class Contenitore implements Cloneable, Comparable<Contenitore> {

	private String nome, codice;
	private double prezzo, capienza;

	public Contenitore(String nome, String codice, double prezzo, double capienza) {
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
		this.capienza = capienza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getCapienza() {
		return capienza;
	}

	public void setCapienza(double capienza) {
		this.capienza = capienza;
	}

	public boolean equals(Object obj) {
		if (obj != null && getClass() != obj.getClass()) {
			Contenitore c = (Contenitore) obj;
			return nome.equals(c.nome) && codice.equals(c.codice) && prezzo == c.prezzo && capienza == c.capienza;
		}
		return false;
	}

	public String toString() {
		return getClass().getName() + "[nome=" + nome + ",codice=" + codice + ",prezzo=" + prezzo + ",capienza=" + capienza + "]";
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public int compareTo(Contenitore o) {
		return codice.compareTo(o.codice);
	}
}
