package traccie.mensa.serializzazione;

import traccie.mensa.database.Database;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1000000001L;
	private String username, password;
	private String cognome, nome;
	private float credito;
	private ArrayList<Pasto> pasti = new ArrayList<>();

	public Cliente(String username, String password, String cognome, String nome, float credito) {
		this.username = username;
		this.password = password;
		this.cognome = cognome;
		this.nome = nome;
		this.credito = credito;
	}

	public String getUsername() {
		return username;
	}

	public String getNomeCompleto() {
		return cognome + " " + nome;
	}

	public float getCredito() {
		return credito;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public boolean nuovaSpesa(Pasto pasto) {
		float costo = pasto.getCosto();
		if (credito >= costo) {
			credito -= costo;
			pasti.add(pasto);
			Database.save();
			return true;
		}
		return false;
	}

	public String toString() {
		return username + "-" + password;
	}

}
