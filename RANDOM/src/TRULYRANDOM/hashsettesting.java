package TRULYRANDOM;

import java.util.HashSet;
import java.util.Iterator;

public class hashsettesting {
	public static void main(String[] args) {
		HashSet<Integer> asdf = new HashSet<>();
		asdf.add(1);
		asdf.add(2);
		asdf.add(3);
		asdf.add(4);
		asdf.add(6);
		asdf.add(7);
		asdf.add(5);
		asdf.add(8);

		for (Iterator<Integer> i = asdf.iterator(); i.hasNext();) {
			int p = i.next();
			System.out.println(p);
			i.remove();
		}
	}
}
