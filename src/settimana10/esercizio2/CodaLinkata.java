package settimana10.esercizio2;

public class CodaLinkata<E> {

	private Item<E> head, tail;

	public void enqueue(E item) {
		if (empty()) {
			head = tail = new Item<>(item);
		} else {
			tail.next = new Item<>(item);
			tail = tail.next;
		}
	}

	public E dequeue() {
		if (empty()) {
			return null;
		}
		E res = head.content;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		return res;
	}

	public boolean empty() {
		return head == null;
	}

	private class Item<T> {
		private T content;
		private Item<T> next;

		private Item(T content) {
			this.content = content;
		}
	}

	public static void main() {
		CodaLinkata<String> res = new CodaLinkata<>();
		res.enqueue("ciao");
		res.enqueue("a");
		res.enqueue("tutti");
		res.dequeue();
		res.enqueue("ciaoux");
		String app;
		while ((app = res.dequeue()) != null) {
			System.out.println(app);
		}
	}

}
