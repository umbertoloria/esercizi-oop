package settimana12.esercizio2;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class CerchioWindow extends JFrame {

	/*private Point p = new Point(0, 0);
	private int radius = 10;*/
	private Ellipse2D.Double cerchio = new Ellipse2D.Double(0, 0, 10, 10);
	private Random r = new Random();
	private Color color = new Color(r.nextInt(255 * 255 * 255));
	private boolean shiftPressed = false;

	private CerchioWindow() {
		JPanel panel = new Drawer(this.cerchio);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Box"));

		panel.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
			}

			public void mouseMoved(MouseEvent e) {
//				p.move(e.getX(), e.getY());
				cerchio.x = e.getX() - cerchio.width / 2;
				cerchio.y = e.getY() - cerchio.height / 2;
			}
		});

		panel.addMouseWheelListener(
				(MouseWheelEvent e) -> {
					if (shiftPressed) {
						cerchio.height = Math.max(1, cerchio.height + e.getScrollAmount() * e.getWheelRotation());
					} else {
						cerchio.width = Math.max(1, cerchio.width + e.getScrollAmount() * e.getWheelRotation());
					}
				}
		);

		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					shiftPressed = true;
				} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					e.getComponent().dispatchEvent(new WindowEvent((JFrame) e.getComponent(), WindowEvent.WINDOW_CLOSING));
				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					shiftPressed = false;
				}
			}
		});

		panel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					color = new Color(r.nextInt(255 * 255 * 255));
				}
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});

		add(panel);

		setSize(500, 500);
		setTitle("Cerchio Window");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		new Timer(16, (ActionEvent e) -> panel.repaint()).start();
	}

	class Drawer extends JPanel {

		private Ellipse2D c;

		Drawer(Ellipse2D c) {
			this.c = c;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			((Graphics2D) g).fill(c);
		}
	}

	public static void main() {
		new CerchioWindow();
	}

}
