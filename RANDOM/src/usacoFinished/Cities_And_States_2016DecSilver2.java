
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class Cities_And_States_2016DecSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int citynum = Integer.parseInt(st.nextToken());
		Map<String, Long> cities = new HashMap<>();
		for (int i = 0; i < citynum; i++) {
			st = new StringTokenizer(f.readLine());
			String city = st.nextToken().substring(0, 2);
			String state = st.nextToken();
			if (!city.equals(state))
				if (!cities.containsKey(city + state))
					cities.put(city + state, 1L);
				else
					cities.put(city + state, cities.get(city + state) + 1);
		}
		long count = 0;
		for (String key : cities.keySet()) {
			String otherKey = key.substring(2) + key.substring(0, 2);
			if (cities.containsKey(otherKey))
				count += cities.get(key) * cities.get(otherKey);
		}

		out.println(count / 2);
		out.close();
		f.close();
	}
}