package traccie.mensa.forms;

import traccie.mensa.database.Database;
import traccie.mensa.launcher.Mensa;
import traccie.mensa.serializzazione.Cliente;
import traccie.mensa.serializzazione.Pasto;
import traccie.mensa.serializzazione.Piatto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AcquistaForm extends JFrame {

	public AcquistaForm(Cliente cliente) {
		setTitle("Acquista pasto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(
				"Buongiorno Sig. " + cliente.getNomeCompleto() + ". Il suo credito ammonta a " + cliente.getCredito());
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Costo totale");
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Kcal totale");
		panel.add(lblNewLabel_2);

		Piatto[] piatti = Database.getPiatti();

		DefaultListModel<Piatto> dml = new DefaultListModel<>();
		for (Piatto piatto : piatti) {
			dml.addElement(piatto);
		}

		JList<Piatto> list = new JList<>(dml);
		list.addListSelectionListener((e) -> {
			lblNewLabel_1.setText("Costo totale: " + getPrezzoTotale(list, piatti));
			lblNewLabel_2.setText("Kcal totale: " + getKcalTotale(list, piatti));
		});
		contentPane.add(list, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Acquista");
		btnNewButton.addActionListener((e) -> {
			if (cliente.nuovaSpesa(getPasto(list, piatti))) {
				Mensa.restart();
			} else {
				JOptionPane.showMessageDialog(null, "Non hai abbastanza soldi",
						"Impossibile effettuare l'acquisto", JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		setVisible(true);
	}

	private float getPrezzoTotale(JList<Piatto> list, Piatto[] piatti) {
		float costo_tot = 0;
		for (int i = 0; i <= list.getMaxSelectionIndex(); i++) {
			if (list.isSelectedIndex(i)) {
				costo_tot += piatti[i].getCosto();
			}
		}
		return costo_tot;
	}

	private int getKcalTotale(JList<Piatto> list, Piatto[] piatti) {
		int kcal_tot = 0;
		for (int i = 0; i <= list.getMaxSelectionIndex(); i++) {
			if (list.isSelectedIndex(i)) {
				kcal_tot += piatti[i].getKcal();
			}
		}
		return kcal_tot;
	}

	private Pasto getPasto(JList<Piatto> list, Piatto[] piatti) {
		ArrayList<Piatto> ps = new ArrayList<>();
		for (int i = 0; i <= list.getMaxSelectionIndex(); i++) {
			if (list.isSelectedIndex(i)) {
				ps.add(piatti[i]);
			}
		}
		return new Pasto(ps);
	}

}
