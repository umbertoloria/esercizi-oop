package settimana8.esercizio5;

public class Rettangolo extends FiguraGeometrica {

	private double altezza;

	public Rettangolo(double base, double altezza) {
		super(base);
		this.altezza = altezza;
	}

	public double getAltezza() {
		return altezza;
	}

	@Override
	public double getArea() {
		return getBase() * altezza;
	}

	@Override
	public double getPerimetro() {
		return 2 * (getBase() + altezza);
	}

}
