package settimana10.esercizio2;

public class ListaLinkata<E> {

	private Item<E> first;
	private int size = 0;

	public void add(E item) {
		if (empty()) {
			first = new Item<>(item);
		} else {
			Item<E> app = first;
			for (int i = 0; i < size - 1; i++) {
				app = app.next;
			}
			app.next = new Item<>(item);
		}
		size++;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		if (empty()) {
			return null;
		}
		Item<E> app = first;
		int i = 0;
		while (i < index && app.next != null) {
			app = app.next;
			i++;
		}
		if (i < index) {
			return null;
		}
		return app.content;
	}

	public void remove(int index) {
		if (!empty() && 0 <= index && index < size) {
			if (index == 0) {
				first = first.next;
			} else {
				Item<E> app = first;
				int i = 0;
				while (i < index - 1/* && app.next != null*/) {
					app = app.next;
					i++;
				}
				//assert app.next != null;
				app.next = app.next.next;
			}
			size--;
		}
	}

	private class Item<T> {
		private T content;
		private Item<T> next;

		private Item(T content) {
			this.content = content;
		}
	}

	public static void main() {
		ListaLinkata<String> res = new ListaLinkata<>();
		res.add("ciao");
		res.add("a");
		res.add("tutti");
		res.remove(1);
		res.add("ciaoux");
		for (int i = 0; i < res.size; i++) {
			System.out.println(res.get(i));
		}
	}

}
