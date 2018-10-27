package settimana6.interfacce;

import settimana2.esercizio1.BankAccount;
import settimana5.esercizio1.Coin;

public class DataSet {

	private double sum = 0;
	private int count = 0;
	private Measurable min, max;

	public double getAverage() {
		if (count == 0) {
			return 0;
		}
		return sum / count;
	}

	public void add(Measurable m) {
		sum += m.getMeasure();
		if (count == 0 || min.getMeasure() > m.getMeasure()) {
			min = m;
		}
		if (count == 0 || max.getMeasure() < m.getMeasure()) {
			max = m;
		}
		count++;
	}

	public Measurable getMin() {
		return min;
	}

	public Measurable getMax() {
		return max;
	}

	public static void main() {

		DataSet ds = new DataSet();

		ds.add(new BankAccount(2300));
		ds.add(new BankAccount(1900));
		ds.add(new BankAccount(2000));
		ds.add(new Coin("1 euro", 1));

		System.out.println("Saldo medio   : " + ds.getAverage());
		System.out.println("Saldo maggiore: " + ds.getMax().getMeasure());
		System.out.println("Saldo minore  : " + ds.getMin().getMeasure());

	}

}
