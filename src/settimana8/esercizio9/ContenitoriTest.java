package settimana8.esercizio9;

public class ContenitoriTest {

	public static void main() {

		ElencoContenitori ec = new ElencoContenitori();

		ec.add(new ContenitoreCilindrico("Umberto", "Loria", 12, 50, 10, 10));
		ec.add(new ContenitoreCubico("Michelantonio", "Panichella", 8, 50, 10));
		ec.add(new ContenitoreCilindrico("Mario", "Romano", 5, 50, 10, 10));
		ec.add(new ContenitoreCubico("Simone", "Calabrese", 5, 50, 10));
		ec.add(new ContenitoreCubico("Antonio", "Napoli", 15, 50, 10));

		System.out.println("ELENCO CONTENITORI");
		while (ec.hasNext()) {
			System.out.println(ec.next());
		}
		System.out.println();

		System.out.println("MINOR CONTENITORE");
		System.out.println(ec.getMin(true) + "\n");

		System.out.println("MAGGIOR CONTENITORE");
		System.out.println(ec.getMax(true));

	}

}
