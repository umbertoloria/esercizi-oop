package settimana8.esercizio9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ElencoContenitori implements Iterator<Contenitore> {

	private ArrayList<Contenitore> contenitori;
	private int index = 0;
	private Comparator<Contenitore> ordine_nome = new Comparator<>() {
		public int compare(Contenitore o1, Contenitore o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
	};
	/*
		ALTRI MODI:
		Usando LAMBDA:              (o1, o2) -> o1.getNome().compareTo(o2.getNome())
		Usando Native Comparator:   Comparator.comparing(Contenitore::getNome)
	*/

	public ElencoContenitori() {
		contenitori = new ArrayList<>();
	}

	public void add(Contenitore c) {
		contenitori.add(c);
	}

	public Contenitore getMin(boolean perNome) {
		return Collections.min(contenitori, perNome ? ordine_nome : null);
	}

	public Contenitore getMax(boolean perNome) {
		return Collections.max(contenitori, perNome ? ordine_nome : null);
	}

	public boolean hasNext() {
		return index < contenitori.size();
	}

	public Contenitore next() {
		return contenitori.get(index++);
	}

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
		System.out.println(ec.getMax(true) + "\n");

	}

}
