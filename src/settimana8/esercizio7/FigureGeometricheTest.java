package settimana8.esercizio7;

import settimana8.esercizio6.Cerchio;
import settimana8.esercizio6.FiguraGeometrica;
import settimana8.esercizio6.Rettangolo;
import settimana8.esercizio6.TriangoloIsoscele;

import java.util.Random;

public class FigureGeometricheTest {

	private static final Random r = new Random();

	public static void main() {
		FiguraGeometrica[] fg = new FiguraGeometrica[10];
		for (int i = 0; i < fg.length; i++) {
			if (r.nextBoolean()) {
				fg[i] = new Cerchio(genera());
			} else if (r.nextBoolean()) {
				fg[i] = new Rettangolo(genera(), genera());
			} else {
				fg[i] = new TriangoloIsoscele(genera(), genera());
			}
		}
		double perimetri = 0;
		double aree = 0;
		for (FiguraGeometrica fig : fg) {
			System.out.println(fig);
			perimetri += fig.getPerimetro();
			aree += fig.getArea();
		}
		System.out.println("Perimetri: " + perimetri);
		System.out.println("Aree2: " + aree);
	}

	private static double genera() {
		return 1 + r.nextInt(10);
	}
}
