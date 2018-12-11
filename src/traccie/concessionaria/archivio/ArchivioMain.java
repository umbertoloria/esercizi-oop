package traccie.concessionaria.archivio;

import traccie.concessionaria.frames.LogFrame;

import javax.swing.*;

public class ArchivioMain {

	public static void main() {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Ho bisogno di un file.", "Nessun file caricato",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		String filepath = chooser.getSelectedFile().getAbsolutePath();
		// Per creare un file di esempio, eseguire questa istruzione
		// ArchivioAutomezzi.writeFile(filepath);
		ArchivioAutomezzi.readFile(filepath);
		new LogFrame();
	}

}
