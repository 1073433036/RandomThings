/**
 * This program/class takes 100 random numbers from 6, 10, 14, 18, 22
 * 
 * @author JustinKim
 */

package CSA;

import java.util.HashMap;
import java.util.Random;

public class Unit5Activity1_4 {
	public static void main(String[] args) {
		Random rng = new Random(1);
		HashMap<Integer, Integer> counter = new HashMap<>();
		int[] set = { 6, 10, 14, 18, 22 };

		for (int i = 0; i < 5; i++) {
			counter.put(set[i], 0);
		}

		for (int i = 0; i < 100; i++) {
			int key = rng.nextInt(5);
			counter.put(set[key], counter.get(set[key]) + 1);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(set[i] + ": " + counter.get(set[i]));
		}

	}
}
