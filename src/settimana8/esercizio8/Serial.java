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

	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Serial s = (Serial) obj;
			if (firstEpisode == null) {
				return title.toLowerCase().equals(s.title.toLowerCase()) && s.firstEpisode == null;
			}
			return title.toLowerCase().equals(s.title.toLowerCase()) && firstEpisode.equals(s.firstEpisode);
		}
		return false;
	}

}
