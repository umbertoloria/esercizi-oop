package settimana3.esercizio1;

public class DistributoreBibite {

	private int lattineCount = 0;
	private int gettoniCount = 0;
	private int gettoniEver = 0;

	public DistributoreBibite (int lattineCount) {
		this.lattineCount = lattineCount;
	}

	public void pushGettone() {
		gettoniCount++;
		lattineCount--;
	}

	public void pushLattine(int amount) {
		lattineCount += amount;
	}

	public int getLattineCount() {
		return lattineCount;
	}

	public int getGettoniCount() {
		return gettoniCount;
	}
}
