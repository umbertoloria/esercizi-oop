package settimana8.esercizio8;

public class Serial {

	private String title;
	private Episode firstEpisode;

	public Serial(String title, Episode firstEpisode) {
		this.title = title;
		this.firstEpisode = firstEpisode;
	}

	public String toString() {
		return getClass().getName() + "[title=" + title + "]\n" + firstEpisode;
	}

	public boolean equals(Serial s) {
		if (firstEpisode == null) {
			return title.toLowerCase().equals(s.title.toLowerCase()) && firstEpisode == s.firstEpisode;
		}
		return title.toLowerCase().equals(s.title.toLowerCase()) && firstEpisode.equals(s.firstEpisode);
	}

}
