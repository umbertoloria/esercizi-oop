package settimana1.esercizio1;

public class StampaCarattereCentrale {

	public static void main(String str) {
		String st;
		int half = str.length() / 2;
		if (str.length() % 2 == 0) {
			st = str.substring(half - 1, half + 1);
		} else {
			st = str.charAt(half) + "";
		}
		System.out.println("Caratteri centrali di " + str + ": " + st);
	}

}
