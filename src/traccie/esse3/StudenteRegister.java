package traccie.esse3;

import javax.swing.*;
import java.awt.*;

class StudenteRegister extends JFrame {

	StudenteRegister() {
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

		JLabel matricolaLabel = new JLabel("Matricola");
		gbc.gridx = 0;
		gbc.gridy = 2;
		form.add(matricolaLabel, gbc);

		JTextField matricolaInput = new JTextField();
		gbc.gridx = 1;
		form.add(matricolaInput, gbc);

		JLabel insegnamentoLabel = new JLabel("Insegnamento");
		gbc.gridx = 0;
		gbc.gridy = 3;
		form.add(insegnamentoLabel, gbc);

		JComboBox<String> insegnamentoInput = new JComboBox<>(new String[]{"Reti", "Sistemi"});
		gbc.gridx = 1;
		form.add(insegnamentoInput, gbc);

		JLabel usernameLabel = new JLabel("Username");
		gbc.gridx = 0;
		gbc.gridy = 4;
		form.add(usernameLabel, gbc);

		JTextField usernameInput = new JTextField();
		gbc.gridx = 1;
		form.add(usernameInput, gbc);

		JLabel passwordLabel = new JLabel("Password");
		gbc.gridx = 0;
		gbc.gridy = 5;
		form.add(passwordLabel, gbc);

		JPasswordField passwordInput = new JPasswordField();
		gbc.gridx = 1;
		form.add(passwordInput, gbc);

		JButton btn = new JButton("Registra");
		btn.addActionListener((e) -> {
			Studente studente;
			if (insegnamentoInput.getSelectedIndex() == 0) {
				studente = new Studente(nomeInput.getText(), cognomeInput.getText(), matricolaInput.getText(),
						"Reti", new String(passwordInput.getPassword()));
				studente.addEsame(new Esame("Architettura degli Elaboratori"));
				studente.addEsame(new Esame("Programmazione 1"));
				studente.addEsame(new Esame("Programmazione 2"));
				studente.addEsame(new Esame("Programmazione WEB"));
				studente.addEsame(new Esame("Reti di Calcolatori"));
				studente.addEsame(new Esame("Sistemi Operativi"));
			} else {
				studente = new Studente(nomeInput.getText(), cognomeInput.getText(), matricolaInput.getText(),
						"Sistemi", new String(passwordInput.getPassword()));
				studente.addEsame(new Esame("Introduzione agli Algoritmi e alle Strutture Dati"));
				studente.addEsame(new Esame("Programmazione 1"));
				studente.addEsame(new Esame("Basi di Dati"));
				studente.addEsame(new Esame("Programmazione 2"));
				studente.addEsame(new Esame("Ingegneria del Software"));
				studente.addEsame(new Esame("Programmazione Distribuita"));
			}
			boolean handle = Database.register(usernameInput.getText(), studente);
			if (handle) {
				Login.restart();
			} else {
				JOptionPane.showMessageDialog(null, "Username occupato.");
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		form.add(btn, gbc);

		return form;
	}

}
