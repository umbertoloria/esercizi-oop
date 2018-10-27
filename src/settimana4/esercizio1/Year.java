package settimana4.esercizio1;

public class Year {

	private int year;

	public Year(int year) {
		this.year = year;
	}

	public boolean isLeap() {
		return year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
	}

	public int getYear() {
		return year;
	}

	public static void main() {
		Month m = new Month(Month.FEBBRAIO);
		System.out.println(m.getDays());
	}

}
