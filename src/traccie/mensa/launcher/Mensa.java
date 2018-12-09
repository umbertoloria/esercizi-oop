package traccie.mensa.launcher;

import traccie.mensa.database.Database;
import traccie.mensa.forms.AcquistaForm;
import traccie.mensa.forms.LoginForm;
import traccie.mensa.serializzazione.Cliente;

public class Mensa {

	private static LoginForm loginForm;
	private static AcquistaForm acquistaForm;

	public static void main() {
		// Database.loadData();
		Database.init("clienti.dat");
		restart();
	}

	public static void restart() {
		if (acquistaForm != null) {
			acquistaForm.setVisible(false);
			acquistaForm = null;
		}
		loginForm = new LoginForm();
	}

	public static void acquistaForm(Cliente cliente) {
		if (loginForm != null) {
			loginForm.setVisible(false);
			loginForm = null;
		}
		acquistaForm = new AcquistaForm(cliente);
	}

}
