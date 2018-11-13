package traccie.domotica.elettrodomestici;

import java.util.LinkedList;

public abstract class Elettrodomestico<T> {

	private boolean acceso;
	private String nome, marca;
	private int esecuzioni = 0;

	private LinkedList<T> dati = new LinkedList<>();
	private int index;

	public Elettrodomestico(String nome, String marca) {
		this.marca = marca;
		this.nome = nome;
	}

	public void load(T[] dati) {
		for (T dato : dati) {
			this.dati.add(dato);
		}
	}

	public T start() {
		acceso = true;
		return dati.get(index);
	}

	public T next() {
		if (!acceso) {
			throw new RuntimeException("La lavatrice non è accesa.");
		}
		index = avanza(index);
		return dati.get(index);
	}

	public T play() throws RuntimeException {
		if (!acceso) {
			throw new RuntimeException("La lavatrice non è accesa.");
		}
		esecuzioni++;
		return dati.get(index);
	}

	public void stop() {
		acceso = false;
	}

	public abstract int avanza(int lastIndex);

	protected int getIndex() {
		return index;
	}

	public int getCount() {
		return dati.size();
	}

	public boolean acceso() {
		return acceso;
	}

	public String toString() {
		return getClass().getName() + "[nome=" + nome + ",marca=" + marca + ",esecuzioni=" + esecuzioni + "]";
	}

}
