package traccie.concessionaria.frames;

import traccie.concessionaria.archivio.ArchivioAutomezzi;
import traccie.concessionaria.exceptions.TargaErrataException;
import traccie.concessionaria.mezzi.Autoveicolo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class NuovoAutoveicolo extends JFrame {

	private JTextField textField;
	private JTextField textField_1;

	NuovoAutoveicolo(String targa) {
		setTitle("Aggiungi autoveicolo");
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblMarca = new JLabel("Marca");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 0;
		contentPane.add(lblMarca, gbc_lblMarca);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblModello = new JLabel("Modello");
		GridBagConstraints gbc_lblModello = new GridBagConstraints();
		gbc_lblModello.anchor = GridBagConstraints.EAST;
		gbc_lblModello.insets = new Insets(0, 0, 5, 5);
		gbc_lblModello.gridx = 0;
		gbc_lblModello.gridy = 1;
		contentPane.add(lblModello, gbc_lblModello);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblAnno = new JLabel("Anno");
		GridBagConstraints gbc_lblAnno = new GridBagConstraints();
		gbc_lblAnno.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnno.gridx = 0;
		gbc_lblAnno.gridy = 2;
		contentPane.add(lblAnno, gbc_lblAnno);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2018, 2000, 2018, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 2;
		contentPane.add(spinner, gbc_spinner);

		JLabel lblAlimentazione = new JLabel("Alimentazione");
		GridBagConstraints gbc_lblAlimentazione = new GridBagConstraints();
		gbc_lblAlimentazione.anchor = GridBagConstraints.EAST;
		gbc_lblAlimentazione.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlimentazione.gridx = 0;
		gbc_lblAlimentazione.gridy = 3;
		contentPane.add(lblAlimentazione, gbc_lblAlimentazione);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Benzina", "Diesel", "Metano"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);

		JLabel lblNumeroDiPorte = new JLabel("Numero di porte");
		GridBagConstraints gbc_lblNumeroDiPorte = new GridBagConstraints();
		gbc_lblNumeroDiPorte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDiPorte.gridx = 0;
		gbc_lblNumeroDiPorte.gridy = 4;
		contentPane.add(lblNumeroDiPorte, gbc_lblNumeroDiPorte);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(5, 1, null, 1));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_1.gridx = 1;
		gbc_spinner_1.gridy = 4;
		contentPane.add(spinner_1, gbc_spinner_1);

		JLabel lblNumeroDiPost = new JLabel("Numero di posti");
		GridBagConstraints gbc_lblNumeroDiPost = new GridBagConstraints();
		gbc_lblNumeroDiPost.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDiPost.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDiPost.gridx = 0;
		gbc_lblNumeroDiPost.gridy = 5;
		contentPane.add(lblNumeroDiPost, gbc_lblNumeroDiPost);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(4, 1, 10, 1));
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_2.gridx = 1;
		gbc_spinner_2.gridy = 5;
		contentPane.add(spinner_2, gbc_spinner_2);
		GridBagConstraints gbc_btnAggiungi = new GridBagConstraints();
		gbc_btnAggiungi.gridwidth = 2;
		gbc_btnAggiungi.gridx = 0;
		gbc_btnAggiungi.gridy = 6;

		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener((e) -> {
			String marca = textField.getText().trim();
			String modello = textField_1.getText().trim();
			int anno = (int) spinner.getValue();
			String alimentazione = (String) comboBox.getSelectedItem();
			int numeroPorte = (int) spinner_1.getValue();
			int numeroPosti = (int) spinner_2.getValue();
			if (marca.isEmpty() || modello.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Devi compilare tutti i campi.", "Errore",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					ArchivioAutomezzi.inserisci(new Autoveicolo(marca, modello, targa, anno, alimentazione,
							numeroPorte, numeroPosti));
					JOptionPane.showMessageDialog(null, "Autoveicolo caricato", "Inserimento avvenuto",
							JOptionPane.PLAIN_MESSAGE);
					dispose();
				} catch (TargaErrataException ex) {
					JOptionPane.showMessageDialog(null, "Impossibile inserire l'auto.", "Inserimento fallito",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnAggiungi, gbc_btnAggiungi);
		setVisible(true);
	}

}
