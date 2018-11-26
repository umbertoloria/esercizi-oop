package settimana4.esercizio1;

public class Month {

	public static final int GENNAIO = 1;
	public static final int FEBBRAIO = 2;
	public static final int MARZO = 3;
	public static final int APRILE = 4;
	public static final int MAGGIO = 5;
	public static final int GIUGNO = 6;
	public static final int LUGLIO = 7;
	public static final int AGOSTO = 8;
	public static final int SETTEMBRE = 9;
	public static final int OTTTOBRE = 10;
	public static final int NOVEMBRE = 11;
	public static final int DICEMBRE = 12;

	private static final String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private static final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	private int month;

	public Month(int month) {
		if (month < GENNAIO || month > DICEMBRE) {
			throw new RuntimeException();
		}
		this.month = month;
	}

	public String getMonth() {
		return months[month - 1];
	}

	public int getDays() {
		return days[month - 1];
	}

}
