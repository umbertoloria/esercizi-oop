package settimana1.esercizio5;

public class FirstLetterUpperCase {

	public static void main(String str) {
		String newstring = (str.charAt(0) + "").toUpperCase() + str.substring(1);
		System.out.println(newstring);
	}

}
