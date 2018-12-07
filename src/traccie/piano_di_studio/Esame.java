package traccie.piano_di_studio;

class Esame implements Comparable<Esame> {

	private String corso;
	private int voto;
	private String data;
	private String docente;

	Esame(String corso) {
		this.corso = corso;
	}

	void sostieni(int voto, String data, String docente) {
		this.voto = voto;
		this.data = data;
		this.docente = docente;
	}

	String getCorso() {
		return corso;
	}

	int getVoto() {
		return Math.min(voto, 30);
	}

	Object[] getArray() {
		return new Object[]{corso, voto == 31 ? "Lode" : voto, data, docente};
	}

	public int compareTo(Esame o) {
		return this.voto == o.voto ? this.corso.compareTo(o.corso) : o.voto - this.voto;
	}

	boolean sostenuto() {
		return 18 <= voto && voto <= 31;
	}

}
