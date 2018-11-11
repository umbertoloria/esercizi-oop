package settimana8.esercizio6;

public class Rettangolo extends FiguraGeometrica {

	private double altezza;

	public Rettangolo(double base, double altezza) {
		super(base);
		this.altezza = altezza;
	}

	public double getAltezza() {
		return altezza;
	}

	public double getArea() {
		return getBase() * altezza;
	}

	public double getPerimetro() {
		return 2 * (getBase() + altezza);
	}

	public String toString() {
		return getClass().getName() + "[base=" + getBase() + ",altezza=" + altezza + "]";
	}

}
