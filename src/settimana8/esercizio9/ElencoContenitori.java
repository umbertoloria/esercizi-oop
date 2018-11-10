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

	/**
	 Constructs an ElencoContenitori with no Contenitori.
	 */
	public ElencoContenitori() {
		contenitori = new ArrayList<>();
	}

	/**
	 Adds a Contenitore in this ElencoContenitori.
	 @param c is the Contenitore to add
	 */
	public void add(Contenitore c) {
		contenitori.add(c);
	}

	/**
	 Gets the first Contenitore in the ElencoContenitori ordered by code or by name.
	 @param perNome defines the order-mode ({@code true} for name, {@code false} for code)
	 @return the first Contenitore in this list
	 */
	public Contenitore getMin(boolean perNome) {
		return Collections.min(contenitori, perNome ? ordine_nome : null);
	}

	/**
	 Gets the last Contenitore in the ElencoContenitori ordered by code or by name.
	 @param perNome defines the order-mode ({@code true} for name, {@code false} for code)
	 @return the last Contenitore in this list
	 */
	public Contenitore getMax(boolean perNome) {
		return Collections.max(contenitori, perNome ? ordine_nome : null);
	}

	/**
	 Gets {@code true} if there is an element to get.
	 @return the next element
	 */
	public boolean hasNext() {
		return index < contenitori.size();
	}

	/**
	 Gets the next element to read.
	 @return the next element
	 @throws IndexOutOfBoundsException if there are no more elements.
	 */
	public Contenitore next() {
		return contenitori.get(index++);
	}

}
