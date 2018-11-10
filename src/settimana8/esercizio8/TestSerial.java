package settimana8.esercizio8;

public class TestSerial {

	public static void main() {
		Episode e11 = new Episode("Ricksky business", "");
		Episode e10 = new Episode("Incontri ravvicinati del Rick-tipo", "", e11);
		Episode e9 = new Episode("Qualcosa di Rick-istro sta per accadere", "", e10);
		Episode e8 = new Episode("Vite alternative", "", e9);
		Episode e7 = new Episode("Morty Junior", "", e8);
		Episode e6 = new Episode("Febbre d'amore n°9", "", e7);
		Episode e5 = new Episode("La tribù dei Miguardi", "", e6);
		Episode e4 = new Episode("M.Night Shyam-alieni", "", e5);
		Episode e3 = new Episode("Il parco di anatomia", "", e4);
		Episode e2 = new Episode("Evoluzione carina", "", e3);
		Episode e1 = new Episode("I semi della discordia", "", e2);

		Serial s = new Serial("Rick e Morty", e1);

		System.out.println(s);

		Episode e4alt = new Episode("m.Night Shyam-alieni", "", e5);

		if (e4.equals(e4alt)) {
			System.out.println("Yeah!");
		} else {
			System.out.println("Nouh...");
		}

	}

}
