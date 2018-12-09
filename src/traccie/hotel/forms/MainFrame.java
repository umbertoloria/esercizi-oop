package traccie.hotel.forms;

import traccie.hotel.clienti.Cliente;
import traccie.hotel.clienti.Prenotazione;
import traccie.hotel.clienti.Stanza;
import traccie.hotel.dati.Database;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.GregorianCalendar;

public class MainFrame extends JFrame {

	private static MainFrame mainFrame;
	private static RichiestaPrenotazioneFrame richiestaPrenotazioneFrame;
	private static DettagliClienteFrame dettagliClienteFrame;
	private static AutenticazioneFrame autenticazioneFrame;
	private static GestisciPrenotazioniFrame gestisciPrenotazioniFrame;

	private static void open() {
		mainFrame = new MainFrame();
	}

	private static void richiestaPrenotazione() {
		mainFrame.setVisible(false);
		mainFrame = null;
		richiestaPrenotazioneFrame = new RichiestaPrenotazioneFrame();
	}

	static void verificaPrenotazione(GregorianCalendar checkin, GregorianCalendar checkout, String tipo) {
		richiestaPrenotazioneFrame.setVisible(false);
		richiestaPrenotazioneFrame = null;
		Stanza[] stanze = Database.getStanzeDisponibili(checkin, checkout, tipo);
		if (stanze.length == 0) {
			JOptionPane.showMessageDialog(null, "Non ci sono stanze disponibili");
			open();
		} else {
			Object scelta = JOptionPane.showInputDialog(null, "Ecco le possibili stanze", "Prenota una stanza",
					JOptionPane.QUESTION_MESSAGE, null, stanze, stanze[0]);
			if (scelta instanceof Stanza) {
				dettagliClienteFrame = new DettagliClienteFrame(checkin, checkout, (Stanza) scelta);
			} else {
				JOptionPane.showMessageDialog(null, "Riprova", "Prenotazione fallita", JOptionPane.ERROR_MESSAGE);
				open();
			}
		}
	}

	static void chiudiPrenotazione(GregorianCalendar checkin, GregorianCalendar checkout, Cliente cliente,
	                               Stanza stanza) {
		dettagliClienteFrame.setVisible(false);
		dettagliClienteFrame = null;
		if (cliente != null) {
			stanza.prenota(checkin, checkout, cliente, true);
			JOptionPane.showMessageDialog(null, "Arrivederci!", "Prenotazione avvenuta", JOptionPane.PLAIN_MESSAGE);
			open();
		} else {
			JOptionPane.showMessageDialog(null, "Riprova", "Prenotazione fallita", JOptionPane.ERROR_MESSAGE);
		}
	}

	static void autenticazione() {
		if (mainFrame != null) {
			mainFrame.setVisible(false);
			mainFrame = null;
		}
		if (gestisciPrenotazioniFrame != null) {
			gestisciPrenotazioniFrame.setVisible(false);
			gestisciPrenotazioniFrame = null;
		}
		autenticazioneFrame = new AutenticazioneFrame();
	}

	static void gestisciQuestePrenotazioni(Prenotazione[] prenotazioni) {
		autenticazioneFrame.setVisible(false);
		autenticazioneFrame = null;
		gestisciPrenotazioniFrame = new GestisciPrenotazioniFrame(prenotazioni);
	}

	private MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 196);
		setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.CENTER, 10, 50);
		contentPane.setLayout(fl_contentPane);

		JButton btnNewButton = new JButton("Richiedi prenotazione");
		btnNewButton.addActionListener((e) -> richiestaPrenotazione());
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Gestisci prenotazioni");
		btnNewButton_1.addActionListener((e) -> autenticazione());
		contentPane.add(btnNewButton_1);
	}

	public static void main() {
		JFileChooser f = new JFileChooser();
		if (f.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			System.err.println("Impossibile aprire il file.");
			System.exit(1);
		}
		Database.init(f.getSelectedFile());
		open();
	}

}
