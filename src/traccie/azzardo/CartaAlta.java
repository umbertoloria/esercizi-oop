package traccie.azzardo;

class CartaAlta extends Gioco {

	private int[] banco = new int[2];
	private int[] mano = new int[2];

	CartaAlta(double costo) {
		super(costo);
	}

	public boolean gioca() {
		banco[0] = genera();
		banco[1] = genera();
		mano[0] = genera();
		mano[1] = genera();
		System.out.print("Mano banco ");
		Lottomatica.printArray(banco);
		System.out.print("Mano mia   ");
		Lottomatica.printArray(mano);
		return mano[0] > banco[0] && mano[1] > banco[1];
	}

	public double dammiVincita() {
		if (mano[0] > banco[0] && mano[1] > banco[1]) {
			return getCosto() * 5;
		}
		return 0;
	}

	public String toString() {
		String res = getClass().getName() + "[costo=";
		res += getCosto() + ",banco=[" + banco[0] + ",";
		res += banco[1] + "],mano=[" + mano[0] + ",";
		res = mano[1] + "]]";
		return res;
	}

}
