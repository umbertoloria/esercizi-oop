package traccie.esse3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class Libretto extends JFrame {

	Libretto(String username) {
		getContentPane().setLayout(new BorderLayout());

		add(createTitle(username), BorderLayout.NORTH);
		add(createEsamiList(username), BorderLayout.CENTER);

		JButton closeBtn = new JButton("Chiudi");
		closeBtn.addActionListener((e) -> Login.restart());
		add(closeBtn, BorderLayout.SOUTH);

		setSize(700, 500);
		setVisible(true);
	}

	private JPanel createTitle(String nome) {
		JPanel upper = new JPanel();

		JLabel title = new JLabel();
		title.setText("Benvenuto " + Database.getNomeCompleto(nome) + ": la tua media è "
				+ Database.getMediaVoti(nome) + " e il tuo piano è " + Database.getPiano(nome));
		upper.add(title);

		add(upper);
		return upper;
	}

	private JPanel createEsamiList(String username) {
		JPanel list = new JPanel();

		Object[] headers = new String[]{"Insegnamento", "Voto", "Data", "Docente"};
		Object[][] dati = Database.getVotiAbout(username);

		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setDataVector(dati, headers);

		JTable t = new JTable(dtm);
		JScrollPane sp = new JScrollPane(t);
		t.setFillsViewportHeight(true);

		list.add(sp);

		return list;
	}

}
