package settimana12.esercizio4;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Random;

public class RettangoliCasuali extends JFrame {

	private Random r = new Random();

	private RettangoliCasuali(int n) {
		Rectangle screen = new Rectangle(0, 0, 500, 500);
		JPanel panel = new Drawer(n);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Rettangoli"));

		add(panel);

		setSize(screen.width, screen.height);
		setTitle("Rettangoli Casuali");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		new Timer(16, (e) -> panel.repaint()).start();
	}

	class Drawer extends JPanel {

		private Box[] boxes;

		Drawer(int n) {
			boxes = new Box[n];
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				boxes[i] = new Box(r, this);
			}
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D gr = (Graphics2D) g;
			for (Box box : boxes) {
				box.draw(gr);
			}
		}

		private class Box {

			private Drawer d;
			private Color color;
			private Rectangle box;
			private Point move;
			private int speed;
			private Point app = new Point(0, 0);

			private Box(Random r, Drawer d) {
				this.d = d;
				color = new Color(r.nextInt(255 * 255 * 255));
				move = new Point(1, 1);
				speed = 1 + r.nextInt(5);
			}

			private void draw(Graphics2D g) {
				if (box == null) {
					box = new Rectangle();
					box.x = 20 + r.nextInt(d.getSize().width - 39);
					box.y = 20 + r.nextInt(d.getSize().height - 39);
					box.width = 10 + r.nextInt(21);
					box.height = 10 + r.nextInt(21);
				}

				g.setColor(color);
				app.x = box.x;
				app.y = box.y;
				app.x += move.x * speed;
				app.y += move.y * speed;
				if (app.x < 0 || app.x + box.width > getSize().width) {
					move.x *= -1;
					speed++;
				}
				if (app.y < 0 || app.y + box.height > getSize().height) {
					move.y *= -1;
					speed++;
				}
				box.setLocation(app);

				g.fill(box);
			}
		}

	}

	public static void main() {
		String n = JOptionPane.showInputDialog("Quanti rettangoli vuoi?");
		new RettangoliCasuali(Integer.parseInt(n));
	}

}
