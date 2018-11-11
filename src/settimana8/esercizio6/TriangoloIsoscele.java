package settimana8.esercizio6;

public class TriangoloIsoscele extends FiguraGeometrica {

	private double altezza;

	public TriangoloIsoscele(double base, double altezza) {
		super(base);
		this.altezza = altezza;
	}

	public double getLato() {
		return Math.sqrt(getAltezza() * getAltezza() + getBase() * getBase() / 4);
	}

	public double getAltezza() {
		return altezza;
	}

	public double getArea() {
		return getBase() * altezza / 2;
	}

	public double getPerimetro() {
		return 2 * getLato() + getBase();
	}

	public String toString() {
		return getClass().getName() + "[base=" + getBase() + ",altezza=" + altezza + "]";
	}

}
