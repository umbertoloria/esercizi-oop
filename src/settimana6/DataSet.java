package settimana6;

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

}
