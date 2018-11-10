package settimana8.esercizio8;

public class Episode {

	private String title, plot;
	private Episode next;

	public Episode(String title, String plot) {
		this.title = title;
		this.plot = plot;
	}

	public Episode(String title, String plot, Episode next) {
		this(title, plot);
		this.next = next;
	}

	public void setNext(Episode next) {
		this.next = next;
	}

	public String toString() {
		if (next == null) {
			return getClass().getName() + "[title=" + title + "]";
		}
		return getClass().getName() + "[title=" + title + "]\n" + next;
	}

	public boolean equals(Episode e) {
		if (next == null) {
			return title.toLowerCase().equals(e.title.toLowerCase()) && next == e.next;
		}
		return title.toLowerCase().equals(e.title.toLowerCase()) && next.equals(e.next);
	}

}
