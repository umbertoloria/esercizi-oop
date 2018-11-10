package settimana8.esercizio6;

public class Cerchio extends FiguraGeometrica {

	public Cerchio(double raggio) {
		super(raggio);
	}

	@Override
	public double getArea() {
		return getBase() * getBase() * Math.PI;
	}

	@Override
	public double getPerimetro() {
		return 2 * Math.PI * getBase();
	}

	@Override
	public String toString() {
		return getClass().getName() + "[raggio=" + getBase() + "]";
	}

}
