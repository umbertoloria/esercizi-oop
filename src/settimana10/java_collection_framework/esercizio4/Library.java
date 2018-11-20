package settimana10.java_collection_framework.esercizio4;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Library {

	private Hashtable<String, Set<Book>> books = new Hashtable<>();

	public void add(Book b) {
		String[] tags = b.getTags();
		Set<Book> newset;
		for (String tag : tags) {
			if (books.get(tag) == null) {
				newset = new HashSet<>();
				newset.add(b);
				books.put(tag, newset);
			} else {
				books.get(tag).add(b);
			}
		}
	}

	public Set getBooksByTag(String magia) {
		return books.get(magia);
	}

	public static void main() {
		Library casa = new Library();
		Book b1 = new Book("Harry Potter 1", "Rowling");
		b1.addTag("magia");
		Book b2 = new Book("Harry Potter 2", "Rowling");
		b2.addTag("magia");
		b2.addTag("horror");

		casa.add(b1);
		casa.add(b2);

		System.out.println(casa.getBooksByTag("horror"));
		System.out.println(casa.getBooksByTag("magia"));
	}

}
