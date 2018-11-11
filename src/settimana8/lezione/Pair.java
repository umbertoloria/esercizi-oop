package settimana8.lezione;

public class Pair<T> {

	private T first, second;

	private Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

	public void swap() {
		T tmp = first;
		first = second;
		second = tmp;
	}

	public String toString() {
		return getClass().getName() + "[first=" + first + ",second=" + second + "]";
	}

	public static void main() {
		Pair<Integer> a = new Pair<>(5, 3);
		a.swap();
		System.out.println(a);
	}

}
