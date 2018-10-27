package settimana5.esercizio1;

import java.util.ArrayList;

public class Purse {

	private ArrayList<Coin> coins = new ArrayList<>();
	private double total = 0;

	public void add(Coin c) {
		if (c != null) {
			coins.add(c);
			total += c.getValore();
		}
	}

	public double getTotal() {
		return Math.round(total * 100) / 100d;
	}

	public void remove(Coin c) {
		for (int i = 0; i < coins.size(); i++) {
			if (coins.get(i).equals(c)) {
				coins.remove(i);
				i--;
				total -= c.getValore();
			}
		}
	}

	public boolean hasCoin(Coin c) {
		int count = 0;
		for (Coin coin : coins) {
			if (coin.equals(c)) {
				count++;
			}
		}
		return count == 1;
	}

	public boolean equals(Purse p) {
		if (getTotal() != p.getTotal()) {
			return false;
		}
		for (Coin a : coins) {
			if (!p.hasCoin(a)) {
				return false;
			}
		}
		for (Coin b : p.coins) {
			if (!hasCoin(b)) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Purse[");
		for (Coin coin : coins) {
			res.append(coin.getNome());
			res.append(" = ");
			res.append(coin.getValore());
			res.append(", ");
		}
		int len = res.length();
		res.delete(len - 2, len);
		res.append("]");
		return res.toString();
	}

	public static void main() {
		Purse a = new Purse();
		a.add(new Coin("10 centesimi", 0.1));
		a.add(new Coin("20 centesimi", 0.2));
		a.add(new Coin("50 euro", 50));
		a.remove(new Coin("20 centesimi", 0.2));
		System.out.println(a.getTotal());
		System.out.println(a.toString());
		System.out.println();

		Purse b = new Purse();
		b.add(new Coin("20 centesimi", 0.2));
		b.add(new Coin("10 centesimi", 0.1));
		b.remove(new Coin("20 centesimi", 0.2));
		b.add(new Coin("50 euro", 50));
		System.out.println(b.getTotal());
		System.out.println(b.toString());
		System.out.println();

		System.out.println("Sono uguali? " + a.equals(b));
	}

}
