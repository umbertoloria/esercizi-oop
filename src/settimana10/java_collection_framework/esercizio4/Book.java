package settimana10.java_collection_framework.esercizio4;

import java.util.ArrayList;

public class Book {

	private String title, author;
	private ArrayList<String> tags = new ArrayList<>();

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

	public String[] getTags() {
		return tags.toArray(new String[0]);
	}

	public String toString() {
		return getClass().getName() + "[title=" + title + ",author=" + author + "]";
	}

}
