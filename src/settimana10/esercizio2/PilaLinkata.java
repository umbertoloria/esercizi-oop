package settimana10.esercizio2;

public class PilaLinkata<E> {

	private Item<E> top;

	public E top() {
		return !empty() ? top.content : null;
	}

	public void push(E item) {
		Item<E> second = top;
		top = new Item<>(item);
		top.next = second;
	}

	public E pop() {
		if (empty()) {
			return null;
		}
		E res = top.content;
		top = top.next;
		return res;
	}

	public boolean empty() {
		return top == null;
	}

	private class Item<T> {
		private T content;
		private Item<T> next;

		private Item(T content) {
			this.content = content;
		}
	}

	public static void main() {
		PilaLinkata<String> res = new PilaLinkata<>();
		res.push("ciao");
		res.push("a");
		res.push("tutti");
		res.pop();
		res.push("ciaoux");
		while (res.top() != null) {
			System.out.println(res.pop());
		}
	}

}
