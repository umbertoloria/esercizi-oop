package settimana8.esercizio6;

public class Cerchio extends FiguraGeometrica {

	public Cerchio(double raggio) {
		super(raggio);
	}

	public double getArea() {
		return getBase() * getBase() * Math.PI;
	}

	public double getPerimetro() {
		return 2 * Math.PI * getBase();
	}

	public String toString() {
		return getClass().getName() + "[raggio=" + getBase() + "]";
	}

}
