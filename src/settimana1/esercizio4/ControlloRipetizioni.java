package settimana1.esercizio4;

public class ControlloRipetizioni {

	public static void main(String str, char c) {
		int from = 0;
		int pos;
		while ((pos = str.indexOf(c + "", from)) >= 0) {
			System.out.println("Carattere " + c + " trovato il posizione " + pos);
			from = pos + 1;
		}
		if (from == 0) {
			System.out.println("-1");
		}
	}

}
