package settimana10.programmazione_generica.esercizio1;

public class RicercaLineare {

	public static <E> int ricerca(E[] vec, E item) {
		int i = 0;
		for (E e : vec) {
			if (e.equals(item)) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
