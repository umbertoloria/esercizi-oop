package settimana10.programmazione_generica.esercizio4;

public class Sorter<T extends Comparable<T>> {

	private T last;

	Sorter(T last) {
		this.last = last;
	}

	int check(T last) {
		int res = last.compareTo(this.last);
		this.last = last;
		return res;
	}

}
