package traccie.esse3;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

class Cattedra extends JFrame {

	Cattedra(String username) {

		getContentPane().setLayout(new BorderLayout());

		add(createTitle(username), BorderLayout.NORTH);
		add(createControllerList(username), BorderLayout.CENTER);

		JButton closeBtn = new JButton("Chiudi");
		closeBtn.addActionListener((e) -> Login.restart());
		add(closeBtn, BorderLayout.SOUTH);

		setSize(700, 300);
		setVisible(true);
	}

	private JPanel createTitle(String nome) {
		JPanel upper = new JPanel();

		JLabel title = new JLabel("Benvenuto Prof. " + nome);
		upper.add(title);

		add(upper);
		return upper;
	}

	private JPanel createControllerList(String nome) {
		JPanel list = new JPanel();
		Studente[] studenti = Database.getStudentiSenzaEsame(Database.getCorso(nome));
		if (studenti == null) {
			JOptionPane.showMessageDialog(null, "Non ci sono studenti da valutare.");
			return list;
		}
		String[] matricole = new String[studenti.length];
		for (int i = 0; i < studenti.length; i++) {
			matricole[i] = studenti[i].getMatricola();
		}

		list.setBorder(new TitledBorder(new EtchedBorder(), "Registrazione esame"));
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{170, 170};
		list.setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints();

		JLabel l1 = new JLabel("Matricola studente");
		gbc.gridx = 0;
		gbc.gridy = 0;
		list.add(l1, gbc);

		JComboBox<String> studente = new JComboBox<>(matricole);
		gbc.gridx = 1;
		list.add(studente, gbc);

		JLabel l2 = new JLabel("Voto");
		gbc.gridx = 0;
		gbc.gridy = 1;
		list.add(l2, gbc);

		String[] votiArray = new String[31];
		votiArray[0] = "Lode";
		int i = 1;
		for (int v = 30; v >= 18; v--) {
			votiArray[i++] = v + "";
		}

		JComboBox<String> voti = new JComboBox<>(votiArray);
		gbc.gridx = 1;
		list.add(voti, gbc);

		JButton btn = new JButton("Conferma");
		btn.addActionListener((e) -> {
			int voto;
			String votoStr = (String) voti.getSelectedItem();
			if (votoStr == null) {
				JOptionPane.showMessageDialog(null, "Voto non valido.");
				return;
			}
			if (votoStr.equals("Lode")) {
				voto = 31;
			} else {
				voto = Integer.parseInt((String) voti.getSelectedItem());
			}
			Database.addEsame((String) studente.getSelectedItem(), Database.getNomeCompleto(nome), Database.getCorso(nome), voto);
		});
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		list.add(btn, gbc);

		return list;
	}

}
