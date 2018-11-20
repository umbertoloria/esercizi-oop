package settimana10.programmazione_generica.esercizio4;

public class SorterTest {

	public static void main() {
		Sorter<Integer> s = new Sorter<>(7);
		System.out.println(s.check(4));
		System.out.println(s.check(1));
		System.out.println(s.check(6));
		System.out.println(s.check(6));
	}

}
