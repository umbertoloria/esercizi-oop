package settimana10.java_collection_framework.esercizio3;

import settimana10.java_collection_framework.esercizio2.CollectionChecker;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SafeMergeTool {

	public static <T> LinkedList<T> mergeIfSorted(List<T> a, List<T> b, Comparator<T> comp) {
		if (!CollectionChecker.isSorted(a, comp)) {
			return null;
		}
		if (!CollectionChecker.isSorted(b, comp)) {
			return null;
		}
		LinkedList<T> res = new LinkedList<>();
		int i = 0;
		int j = 0;
		int diff;
		while (i < a.size() && j < b.size()) {
			diff = comp.compare(a.get(i), b.get(j));
			if (diff < 0) {
				res.add(a.get(i++));
			} else if (diff > 0) {
				res.add(b.get(j++));
			} else {
				res.add(a.get(i++));
				j++;
			}
		}
		if (i < a.size()) {
			for (; i < a.size(); i++) {
				res.add(a.get(i));
			}
		} else if (j < b.size()) {
			for (; j < b.size(); j++) {
				res.add(b.get(j));
			}
		}
		return res;
	}

	public static void main() {
		LinkedList<Integer> a = new LinkedList<>();
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(8);
		LinkedList<Integer> b = new LinkedList<>();
		b.add(8);
		b.add(10);
		LinkedList<Integer> res = mergeIfSorted(a, b, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		if (res == null) {
			System.out.println("Errore");
		} else {
			for (Integer re : res) {
				System.out.println(re);
			}
		}
	}

}
