package settimana8.esercizio5;

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

	@Override
	public double getArea() {
		return getBase() * altezza / 2;
	}

	@Override
	public double getPerimetro() {
		return 2 * getLato() + getBase();
	}

}
