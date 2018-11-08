package settimana8.esercizio4;

public class Lavoratore {

	private String nome;
	private String cognome;
	private double pagaOraria;
	private int oreDiLavoro;

	public Lavoratore(String nome, String cognome, double pagaOraria) {
		this.nome = nome;
		this.cognome = cognome;
		this.pagaOraria = pagaOraria;
	}

	public void setOreDiLavoro(int numeroOre) {
		oreDiLavoro = numeroOre;
	}

	public double getPagaOraria() {
		return pagaOraria;
	}

	public int getOreDiLavoro() {
		return oreDiLavoro;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public double getPaga() {
		if (oreDiLavoro <= 40) {
			return pagaOraria * oreDiLavoro;
		}
		return pagaOraria * (40 + (oreDiLavoro - 40) * 1.5);
	}

	@Override
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ",cognome=" + nome + ",pagaOraria=" + pagaOraria + "," +
				"oreDiLavoro=" + oreDiLavoro + "]";
	}

}
