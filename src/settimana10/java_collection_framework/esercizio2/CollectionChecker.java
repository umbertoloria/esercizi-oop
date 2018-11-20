package settimana10.java_collection_framework.esercizio2;

import java.util.*;

public class CollectionChecker {

	public static <T extends Comparable<T>> boolean isSetSmaller(Set<T> a, Set<T> b) {
		for (T aa : a) {
			for (T bb : b) {
				if (aa.compareTo(bb) <= 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static <T> boolean isSorted(Collection<T> coll, Comparator<T> comp) throws IllegalArgumentException {
		if (coll.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Iterator<T> iter = coll.iterator();
		T prev = iter.next();
		T curr = prev;
		while (iter.hasNext()) {
			prev = curr;
			curr = iter.next();
			if (comp.compare(prev, curr) > 0) {
				return false;
			}
		}
		return true;
	}

	public static void mainIsSetSmaller() {
		Set<Integer> a = new HashSet<>();
		a.add(7);
		a.add(4);
		a.add(8);
		Set<Integer> b = new HashSet<>();
		b.add(1);
		b.add(2);
		b.add(3);
		System.out.println(isSetSmaller(a, b));
	}

	public static void mainIsSorted() {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(7);
		l.add(8);
		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		System.out.println(isSorted(l, c));
	}

}
