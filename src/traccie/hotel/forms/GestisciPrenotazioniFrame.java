package traccie.hotel.forms;

import traccie.hotel.clienti.Prenotazione;
import traccie.hotel.dati.Database;
import traccie.hotel.dati.DateUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class GestisciPrenotazioniFrame extends JFrame {

	private JTable table;

	GestisciPrenotazioniFrame(Prenotazione[] prenotazioni) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Object[] headers = new Object[]{"Check-in", "Check-out", "Cliente"};
		Object[][] dati = new Object[prenotazioni.length][];
		for (int i = 0; i < prenotazioni.length; i++) {
			dati[i] = new Object[]{DateUtils.display(prenotazioni[i].getCheckin()),
					DateUtils.display(prenotazioni[i].getCheckout()), prenotazioni[i].getCliente().getNomeCompleto()};
		}

		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setDataVector(dati, headers);
		table = new JTable();
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setResizable(false);
		contentPane.add(table, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton_1 = new JButton("Rimuovi");
		btnNewButton_1.addActionListener((e) -> {
			Database.rimuovi(prenotazioni[table.getSelectedRow()]);
			MainFrame.autenticazione();
		});
		panel.add(btnNewButton_1);
	}

}
