package settimana8.esercizio5;

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

	public static void main() {
		FiguraGeometrica a = new TriangoloIsoscele(7, 8);
		System.out.println("Perimetro: " + a.getPerimetro());
		System.out.println("Area     : " + a.getArea());
	}

}
