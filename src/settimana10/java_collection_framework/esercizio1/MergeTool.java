package settimana10.java_collection_framework.esercizio1;

import java.util.LinkedList;
import java.util.List;

public class MergeTool {

	public static <T> LinkedList<T> merge(List<T> a, List<T> b) {
		if (a.size() != b.size()) {
			throw new IllegalArgumentException("Le liste fornite hanno taglie differenti");
		}
		LinkedList<T> res = new LinkedList<>();
		for (int i = 0; i < a.size(); i++) {
			res.add(a.get(i));
			res.add(b.get(i));
		}
		return res;
	}

	public static void main() {
		LinkedList<Integer> a = new LinkedList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		LinkedList<Integer> b = new LinkedList<>();
		b.add(4);
		b.add(5);
		b.add(6);
		LinkedList<Integer> c = MergeTool.merge(a, b);
		for (Integer integer : c) {
			System.out.println(integer);
		}
	}

}
