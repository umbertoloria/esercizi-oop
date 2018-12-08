package traccie.hotel.forms;

import traccie.hotel.dati.DateUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.GregorianCalendar;

class RichiestaPrenotazioneFrame extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;

	RichiestaPrenotazioneFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCheckin = new JLabel("Check-in");
		GridBagConstraints gbc_lblCheckin = new GridBagConstraints();
		gbc_lblCheckin.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckin.anchor = GridBagConstraints.EAST;
		gbc_lblCheckin.gridx = 0;
		gbc_lblCheckin.gridy = 0;
		contentPane.add(lblCheckin, gbc_lblCheckin);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblCheckout = new JLabel("Check-out");
		GridBagConstraints gbc_lblCheckout = new GridBagConstraints();
		gbc_lblCheckout.anchor = GridBagConstraints.EAST;
		gbc_lblCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckout.gridx = 0;
		gbc_lblCheckout.gridy = 1;
		contentPane.add(lblCheckout, gbc_lblCheckout);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblTipologia = new JLabel("Tipo");
		GridBagConstraints gbc_lblTipologia = new GridBagConstraints();
		gbc_lblTipologia.anchor = GridBagConstraints.EAST;
		gbc_lblTipologia.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipologia.gridx = 0;
		gbc_lblTipologia.gridy = 2;
		contentPane.add(lblTipologia, gbc_lblTipologia);

		String[] tipi = new String[]{"Singola", "Doppia", "Matrimoniale"};

		comboBox = new JComboBox<>(tipi);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);

		JButton btnNewButton = new JButton("Verifica disponibilit\u00E0");
		btnNewButton.addActionListener((e) -> {
			GregorianCalendar in = DateUtils.getFrom(textField.getText());
			GregorianCalendar out = DateUtils.getFrom(textField_1.getText());
			if (in.compareTo(out) < 0) {
				MainFrame.verificaPrenotazione(in, out, (String) comboBox.getSelectedItem());
			} else {
				JOptionPane.showMessageDialog(null, "Date invalide", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
