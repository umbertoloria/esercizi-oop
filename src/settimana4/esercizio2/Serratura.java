package settimana4.esercizio2;

public class Serratura {

	private String comb;
	private String pos;
	private boolean open;

	public Serratura(String comb) {
		this.comb = comb;
	}

	public void setPosition(String pos) {
		this.pos = pos;
	}

	public void unlock() {
		this.open = comb.equals(pos);
	}

	public boolean isOpen() {
		return open;
	}

	public void lock() {
		this.open = false;
	}

	public void newComb(String newComb) {
		if (open) {
			this.comb = newComb;
			this.open = false;
		}
	}

}
