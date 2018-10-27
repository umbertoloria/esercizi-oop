package settimana5.esercizio3;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcessionariaUtils {

	private ArrayList<ModelloAuto> auto = new ArrayList<>();

	public ConcessionariaUtils(String filepath) {
		Scanner in = new Scanner(ConcessionariaUtils.class.getResourceAsStream(filepath));
		ArrayList<String> lines = new ArrayList<>();
		while (in.hasNextLine()) {
			lines.add(in.nextLine());
		}
		int imma;
		double prezzo;
		for (int i = 0; i + 3 < lines.size(); i += 4) {
			try {
				imma = Integer.parseInt(lines.get(i + 2));
				prezzo = Double.parseDouble(lines.get(i + 3));
			} catch (NumberFormatException e) {
				continue;
			}
			auto.add(new ModelloAuto(lines.get(i), lines.get(i + 1), imma, prezzo));
		}
	}

	public ModelloAuto[] esisteAuto(String marca, String modello) {
		ArrayList<ModelloAuto> res = new ArrayList<>();
		for (ModelloAuto modelloAuto : auto) {
			if (modelloAuto.getMarca().equalsIgnoreCase(marca)) {
				if (modelloAuto.getModello().equalsIgnoreCase(modello)) {
					res.add(modelloAuto);
				}
			}
		}
		return res.toArray(new ModelloAuto[0]);
	}

	public ModelloAuto[] esisteAutoRecente(String marca, String modello, int imma) {
		ModelloAuto[] search = esisteAuto(marca, modello);
		ArrayList<ModelloAuto> res = new ArrayList<>();
		for (ModelloAuto modelloAuto : search) {
			if (modelloAuto.getImmatricolazione() >= imma) {
				res.add(modelloAuto);
			}
		}
		return res.toArray(new ModelloAuto[0]);
	}

	public ModelloAuto[] esisteAutoIdonea(String marca, String modello, double minimo, double massimo) {
		ModelloAuto[] search = esisteAuto(marca, modello);
		ArrayList<ModelloAuto> res = new ArrayList<>();
		for (ModelloAuto modelloAuto : search) {
			if (minimo <= modelloAuto.getPrezzo() && modelloAuto.getPrezzo() <= massimo) {
				res.add(modelloAuto);
			}
		}
		return res.toArray(new ModelloAuto[0]);
	}

	public void print() {
		for (ModelloAuto modelloAuto : auto) {
			System.out.println(modelloAuto.toString());
		}
		System.out.println();
	}

}
