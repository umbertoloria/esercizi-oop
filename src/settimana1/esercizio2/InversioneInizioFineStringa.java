package settimana1.esercizio2;

public class InversioneInizioFineStringa {

	public static void main(String str) {
		if (str.length() < 2) return;
		String newstring = str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
		System.out.println("From " + str + " to " + newstring);
	}

}
