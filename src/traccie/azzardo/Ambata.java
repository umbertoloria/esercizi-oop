package traccie.azzardo;

class Ambata extends Gioco {

	private int[] estratti = new int[10];
	private int numero;

	Ambata(double costo) {
		super(costo);
	}

	public boolean gioca() {
		numero = genera();
		boolean res = false;
		int j;
		for (int i = 0; i < estratti.length; i++) {
			do {
				estratti[i] = genera();
				for (j = 0; j < i; j++) {
					if (estratti[i] == estratti[j]) {
						break;
					}
				}
			} while (j < i);
			if (!res && estratti[i] == numero) {
				res = true;
			}
		}
		Lottomatica.printArray(estratti);
		System.out.println("Avevo " + numero);
		for (int i : estratti) {
			if (i == numero) {
				return true;
			}
		}
		return res;
	}

	public double dammiVincita() {
		for (int i : estratti) {
			if (i == numero) {
				return getCosto() * 10;
			}
		}
		return 0;
	}

	public String toString() {
		String res = getClass().getName() + "[costo=";
		res += getCosto() + ",estratti=[";
		for (int i = 0; i < estratti.length - 1; i++) {
			res += estratti[i] + ",";
		}
		res += estratti[estratti.length - 1] + "],numero=";
		res += numero + "]";
		return res;
	}

}
