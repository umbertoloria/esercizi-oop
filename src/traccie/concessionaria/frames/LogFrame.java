package traccie.concessionaria.frames;

import traccie.concessionaria.archivio.ArchivioAutomezzi;
import traccie.concessionaria.exceptions.TargaErrataException;
import traccie.concessionaria.mezzi.Automezzo;
import traccie.concessionaria.mezzi.Autoveicolo;
import traccie.concessionaria.mezzi.Motociclo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LogFrame extends JFrame {

	private JTable table;
	private JTextField textField;
	private JLabel lblNumeroDiQualcosa, lblNumeroDiQualcosa2;
	private JComboBox<String> comboBox;

	public LogFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpenFile = new JMenuItem("Open file");
		mnFile.add(mntmOpenFile);

		JMenuItem mntmSaveFile = new JMenuItem("Save file");
		mnFile.add(mntmSaveFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JRadioButton rdbtnAutoveicolo = new JRadioButton("Autoveicolo");
		rdbtnAutoveicolo.setSelected(true);
		panel_1.add(rdbtnAutoveicolo);

		JRadioButton rdbtnMotociclo = new JRadioButton("Motociclo");
		panel_1.add(rdbtnMotociclo);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnAutoveicolo);
		bg.add(rdbtnMotociclo);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		panel.add(panel_2);

		JLabel lblTarga = new JLabel("Targa");
		panel_2.add(lblTarga);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		lblNumeroDiQualcosa = new JLabel("Alimentazione");
		panel_2.add(lblNumeroDiQualcosa);

		comboBox = new JComboBox<>();
		panel_2.add(comboBox);

		lblNumeroDiQualcosa2 = new JLabel("Numero di posti");
		panel_2.add(lblNumeroDiQualcosa2);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(
				new DefaultComboBoxModel<>(new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		panel_2.add(comboBox_1);

		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener((e) -> {
			String targa = textField.getText().trim();
			if (targa.isEmpty()) {
				if (rdbtnAutoveicolo.isSelected()) {
					String alimentazione = (String) comboBox.getSelectedItem();
					String numeroPosti = (String) comboBox_1.getSelectedItem();
					Autoveicolo[] auto = ArchivioAutomezzi.getAutoveicoliWith(alimentazione,
							numeroPosti.isEmpty() ? 0 : Integer.parseInt(numeroPosti));
					showAutoveicoli(auto);
				} else {
					String anno = (String) comboBox.getSelectedItem();
					String numeroRuote = (String) comboBox_1.getSelectedItem();
					Motociclo[] moto = ArchivioAutomezzi.getMotocicliWith(
							anno.isEmpty() ? 0 : Integer.parseInt(anno),
							numeroRuote.isEmpty() ? 0 : Integer.parseInt(numeroRuote));
					showMotocicli(moto);
				}
			} else {
				if (rdbtnAutoveicolo.isSelected()) {
					try {
						Automezzo.checkTarga(targa, Autoveicolo.targaFormat);
						Autoveicolo[] auto = ArchivioAutomezzi.getAutoveicoliWith(targa);
						if (auto.length > 0) {
							showAutoveicoli(auto);
						} else {
							if (JOptionPane.showConfirmDialog(null, "Nessun autoveicolo con questa targa. Vuoi " +
									"inserirlo?") == 0) {
								new NuovoAutoveicolo(targa);
							}
						}
					} catch (TargaErrataException ex) {
						JOptionPane.showMessageDialog(null, "Formato targa errato!", "Messaggio",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					try {
						Automezzo.checkTarga(targa, Motociclo.targaFormat);
						Motociclo[] moto = ArchivioAutomezzi.getMotocicliWith(targa);
						if (moto.length > 0) {
							showMotocicli(moto);
						} else {
							if (JOptionPane.showConfirmDialog(null, "Nessun motociclo con questa targa. Vuoi " +
									"inserirlo?") == 0) {
								new NuovoMotociclo(targa);
							}
						}
					} catch (TargaErrataException ex) {
						JOptionPane.showMessageDialog(null, "Formato targa errato!", "Messaggio",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel_2.add(btnCerca);

		rdbtnAutoveicolo.addActionListener((e) -> autoveicoloMode());
		rdbtnMotociclo.addActionListener((e) -> motocicloMode());

		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		autoveicoloMode();
		setVisible(true);
	}

	private void autoveicoloMode() {
		String[] cbData = new String[]{"", "Benzina", "Diesel", "Metano"};
		comboBox.setModel(new DefaultComboBoxModel<>(cbData));
		lblNumeroDiQualcosa.setText("Alimentazione");
		lblNumeroDiQualcosa2.setText("Numero di posti");
	}

	private void motocicloMode() {
		String[] cbData = new String[]{"", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
				"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"};
		comboBox.setModel(new DefaultComboBoxModel<>(cbData));
		lblNumeroDiQualcosa.setText("Anno");
		lblNumeroDiQualcosa2.setText("Numero di ruote");
	}

	private void showAutoveicoli(Autoveicolo[] auto) {
		Object[][] dati = new Object[auto.length][];
		for (int i = 0; i < auto.length; i++) {
			dati[i] = auto[i].getTableRow();
		}
		table.setModel(new DefaultTableModel(dati, new String[]{"Marca", "Modello", "Targa", "Alimentazione",
				"Numero posti", "Numero di porte", "Numero di posti"}) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void showMotocicli(Motociclo[] moto) {
		Object[][] dati = new Object[moto.length][];
		for (int i = 0; i < moto.length; i++) {
			dati[i] = moto[i].getTableRow();
		}
		table.setModel(new DefaultTableModel(dati,
				new String[]{"Marca", "Modello", "Targa", "Numero ruote", "Numero passeggeri"}) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

}
