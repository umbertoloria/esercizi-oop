package settimana7.esercizio3;

import settimana7.esercizio2.DataSetComparable;

public class Country implements Comparable<Country> {

	private String nome;
	private double superficie;

	public Country(String nome, double superficie) {
		this.nome = nome;
		this.superficie = superficie;
	}

	public int compareTo(Country a) {
		return (int) (superficie - a.superficie);
	}

	public String toString() {
		return "[" + nome + ", " + superficie + "]";
	}

	public static void main() {
		DataSetComparable dsc = new DataSetComparable();
		dsc.add(new Country("Italia", 302072.84));
		dsc.add(new Country("USA", 9372614));
		dsc.add(new Country("Canada", 9897170));
		dsc.add(new Country("Australia", 7617930));
		dsc.add(new Country("Russia", 17125191));
		dsc.add(new Country("UK", 242495));
		System.out.println(dsc.getMin().toString());
		System.out.println(dsc.getMax().toString());
	}

}
