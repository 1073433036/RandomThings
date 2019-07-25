
//package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cow_Routing_2015JanSilver2 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int startCity = Integer.parseInt(st.nextToken()) - 1;
		int endCity = Integer.parseInt(st.nextToken()) - 1;
		int numRoutes = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> routes = new ArrayList<>(numRoutes);
		HashMap<Integer, Integer> cityNums = new HashMap<>();
		int[] routecost = new int[numRoutes];
		for (int i = 0; i < numRoutes; i++) {
			st = new StringTokenizer(f.readLine());
			routecost[i] = Integer.parseInt(st.nextToken());
			int numCities = Integer.parseInt(st.nextToken());
			routes.add(new ArrayList<Integer>(numCities));
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < numCities; j++) {
				int city = Integer.parseInt(st.nextToken()) - 1;
				if (!cityNums.containsKey(city)) {
					cityNums.put(city, cityNums.size());
				}
				routes.get(i).add(cityNums.get(city));
			}
		}
		if (cityNums.containsKey(startCity) && cityNums.containsKey(endCity)) {
			startCity = cityNums.get(startCity);
			endCity = cityNums.get(endCity);
		}
		else {
			out.println("-1 -1");
			out.close();
			f.close();
			return;
		}

		int numCities = cityNums.size();
		int[][] flightpaths = new int[numCities][numCities];
		int[][] citypaths = new int[numCities][numCities];
		for (int i = 0; i < numCities; i++) {
			for (int j = 0; j < numCities; j++) {
				flightpaths[i][j] = Integer.MAX_VALUE;
				citypaths[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < numRoutes; i++) {
			for (int j = 0; j < routes.get(i).size(); j++) {
				for (int k = j + 1; k < routes.get(i).size(); k++) {
					int test = flightpaths[routes.get(i).get(j)][routes.get(i).get(k)];
					if (test > routecost[i]) {
						flightpaths[routes.get(i).get(j)][routes.get(i).get(k)] = routecost[i];
						citypaths[routes.get(i).get(j)][routes.get(i).get(k)] = k - j;
					}
				}
			}
		}

		boolean[] visited = new boolean[numCities];
		long[] dist = new long[numCities];
		int[] cityDist = new int[numCities];
		for (int i = 0; i < numCities; i++) {
			dist[i] = Long.MAX_VALUE;
			cityDist[i] = Integer.MAX_VALUE;
		}
		dist[startCity] = 0;
		cityDist[startCity] = 0;
		boolean impossible = false;
		for (int cities = 0; cities < numCities; cities++) {
			int min = -1;
			for (int i = 0; i < numCities; i++) {
				if (!visited[i] && (min == -1 || dist[i] < dist[min])) {
					min = i;
				}
			}
			if (dist[min] == Long.MAX_VALUE) {
				impossible = true;
				break;
			}
			if (min == endCity) {
				break;
			}
			visited[min] = true;
			for (int i = 0; i < numCities; i++) {
				if (dist[i] > dist[min] + flightpaths[min][i] && flightpaths[min][i] != Integer.MAX_VALUE) {
					dist[i] = dist[min] + flightpaths[min][i];
					cityDist[i] = cityDist[min] + citypaths[min][i];
				}
				else if (dist[i] == dist[min] + flightpaths[min][i]) {
					cityDist[i] = Math.min(cityDist[i], cityDist[min] + citypaths[min][i]);
				}
			}
		}

		if (impossible) {
			out.println("-1 -1");
		}
		else {
			out.println(dist[endCity] + " " + cityDist[endCity]);
		}
		out.close();
		f.close();
	}
}
