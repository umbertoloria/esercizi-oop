package settimana7.esercizio2;

public class DataSetComparable {

	private int count = 0;
	private Comparable min, max;

	public void add(Comparable m) {
		if (count == 0 || min.compareTo(m) > 0) {
			min = m;
		}
		if (count == 0 || max.compareTo(m) < 0) {
			max = m;
		}
		count++;
	}

	public Comparable getMin() {
		return min;
	}

	public Comparable getMax() {
		return max;
	}

	public static void main () {
		DataSetComparable a = new DataSetComparable();

		a.add("Ciao");
		a.add("a");
		a.add("zbrush");
		a.add("tutti");

		System.out.println(a.getMin());
		System.out.println(a.getMax());
	}

}
