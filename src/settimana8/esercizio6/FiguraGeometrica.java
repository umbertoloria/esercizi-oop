package settimana8.esercizio6;

public abstract class FiguraGeometrica {

	private double base;

	public FiguraGeometrica(double base) {
		this.base = base;
	}

	public double getBase() {
		return base;
	}

	public abstract double getArea();

	public abstract double getPerimetro();

	public abstract String toString();

}
