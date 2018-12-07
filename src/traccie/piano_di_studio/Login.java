package traccie.piano_di_studio;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Login extends JFrame {

	private Login() {
		getContentPane().setLayout(new BorderLayout());

		add(createLoginPanel(), BorderLayout.CENTER);
		add(createLinksPanel(), BorderLayout.SOUTH);

		setSize(500, 500);
		setVisible(true);
	}

	private JTextField tf1;
	private JPasswordField tf2;

	private JPanel createLoginPanel() {
		JPanel login = new JPanel();

		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{180, 180};
		login.setLayout(gbl);

		JLabel title = new JLabel("Benvenuti nel Sistema eVoto");
		title.setBackground(Color.BLUE);

		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 0;
		a.gridwidth = 2;
		a.gridheight = 1;
		a.fill = GridBagConstraints.HORIZONTAL;
		login.add(title, a);


		JLabel l1 = new JLabel("Username");
		a.gridx = 0;
		a.gridy = 1;
		a.gridwidth = 1;
		login.add(l1, a);

		tf1 = new JTextField();
		tf1.addActionListener((e) -> loginProcedure());
		a.gridx = 1;
		login.add(tf1, a);

		JLabel l2 = new JLabel("Password");
		a.gridx = 0;
		a.gridy = 2;
		login.add(l2, a);

		tf2 = new JPasswordField();
		tf2.addActionListener((e) -> loginProcedure());
		a.gridx = 1;
		a.gridy = 2;
		login.add(tf2, a);

		JButton btn = new JButton("Accedi");
		btn.addActionListener((e) -> loginProcedure());

		a.gridx = 0;
		a.gridy = 3;
		a.gridwidth = 2;
		login.add(btn, a);

		return login;
	}

	private JPanel createLinksPanel() {
		JPanel links = new JPanel();
		links.setBorder(new TitledBorder(new EtchedBorder(), "Registrazione"));

		JButton studenteReg = new JButton("Studente");
		studenteReg.addActionListener((e) -> showStudenteRegister());
		JButton docenteReg = new JButton("Docente");
		docenteReg.addActionListener((e) -> showDocenteRegister());

		links.add(studenteReg, BorderLayout.WEST);
		links.add(docenteReg, BorderLayout.EAST);
		return links;
	}

	private void loginProcedure() {
		int handle = Database.login(tf1.getText(), new String(tf2.getPassword()));
		if (handle == Database.STUDENTE) {
			showVoti(tf1.getText());
		} else if (handle == Database.PROFESSORE) {
			showEsse3(tf1.getText());
		} else {
			JOptionPane.showMessageDialog(null, "Credenziali non valide.");
			tf1.setText("");
			tf2.setText("");
		}
	}

	public static void main() {
		restart();
	}

	private static Login loginFrame;
	private static Libretto librettoFrame;
	private static Cattedra cattedraFrame;
	private static StudenteRegister studenteRegister;
	private static DocenteRegister docenteRegister;

	static void restart() {
		disposeEverything();
		loginFrame = new Login();
	}

	private static void disposeEverything() {
		if (loginFrame != null) {
			loginFrame.setVisible(false);
		}
		if (librettoFrame != null) {
			librettoFrame.setVisible(false);
		}
		if (cattedraFrame != null) {
			cattedraFrame.setVisible(false);
		}
		if (studenteRegister != null) {
			studenteRegister.setVisible(false);
		}
		if (docenteRegister != null) {
			docenteRegister.setVisible(false);
		}
	}

	private static void showVoti(String username) {
		disposeEverything();
		librettoFrame = new Libretto(username);
	}

	private static void showEsse3(String username) {
		disposeEverything();
		cattedraFrame = new Cattedra(username);
	}

	private static void showStudenteRegister() {
		disposeEverything();
		studenteRegister = new StudenteRegister();
	}

	private static void showDocenteRegister() {
		disposeEverything();
		docenteRegister = new DocenteRegister();
	}

}
