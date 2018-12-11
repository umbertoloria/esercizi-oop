package traccie.esse3;

import javax.swing.*;
import java.awt.*;

class DocenteRegister extends JFrame {

	DocenteRegister() {
		add(createForm());

		setSize(500, 300);
		setVisible(true);
	}

	private JPanel createForm() {
		JPanel form = new JPanel();
		GridBagLayout lay = new GridBagLayout();
		lay.columnWidths = new int[]{180, 180};
		form.setLayout(lay);

		GridBagConstraints gbc = new GridBagConstraints();

		JLabel nomeLabel = new JLabel("Nome");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		form.add(nomeLabel, gbc);

		JTextField nomeInput = new JTextField();
		gbc.gridx = 1;
		form.add(nomeInput, gbc);

		JLabel cognomeLabel = new JLabel("Cognome");
		gbc.gridx = 0;
		gbc.gridy = 1;
		form.add(cognomeLabel, gbc);

		JTextField cognomeInput = new JTextField();
		gbc.gridx = 1;
		form.add(cognomeInput, gbc);

		JLabel insegnamentoLabel = new JLabel("Insegnamento");
		gbc.gridx = 0;
		gbc.gridy = 2;
		form.add(insegnamentoLabel, gbc);

		String[] insegnamenti = new String[]{
				"Architettura degli Elaboratori",
				"Programmazione 1",
				"Programmazione 2",
				"Programmazione WEB",
				"Reti di Calcolatori",
				"Sistemi Operativi",
				"Introduzione agli Algoritmi e alle Strutture Dati",
				"Basi di Dati",
				"Ingegneria del Software",
				"Programmazione Distribuita",
		};

		JComboBox<String> insegnamentoInput = new JComboBox<>(insegnamenti);
		gbc.gridx = 1;
		form.add(insegnamentoInput, gbc);

		JLabel usernameLabel = new JLabel("Username");
		gbc.gridx = 0;
		gbc.gridy = 3;
		form.add(usernameLabel, gbc);

		JTextField usernameInput = new JTextField();
		gbc.gridx = 1;
		form.add(usernameInput, gbc);

		JLabel passwordLabel = new JLabel("Password");
		gbc.gridx = 0;
		gbc.gridy = 4;
		form.add(passwordLabel, gbc);

		JPasswordField passwordInput = new JPasswordField();
		gbc.gridx = 1;
		form.add(passwordInput, gbc);

		JButton btn = new JButton("Registra");
		btn.addActionListener((e) -> {
			Professore professore = new Professore(nomeInput.getText(), cognomeInput.getText(),
					(String) insegnamentoInput.getSelectedItem(), new String(passwordInput.getPassword()));
			boolean handle = Database.register(usernameInput.getText(), professore);
			if (handle) {
				Login.restart();
			} else {
				JOptionPane.showMessageDialog(null, "Username occupato.");
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		form.add(btn, gbc);

		return form;
	}

}
