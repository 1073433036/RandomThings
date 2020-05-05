package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jobscheduling {
	public static class job implements Comparable<job> {
		int weight;
		int length;

		public job(int w, int l) {
			weight = w;
			length = l;
		}

		public int compareTo(job o) {
			// if (o.weight - o.length == weight - length) {
			// return o.weight - weight;
			// }
			//
			// return (o.weight - o.length) - (weight - length);
			// 69119377652

			float ratio = (float) weight / length;
			float oratio = (float) o.weight / o.length;
			if (oratio > ratio) {
				return 1;
			}
			if (oratio < ratio) {
				return -1;
			}
			return 0;
			// 67311454237

		}

		public String toString() {
			return weight + " " + length;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("jobschedule.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numjobs = Integer.parseInt(st.nextToken());
		job[] jobs = new job[numjobs];

		for (int i = 0; i < numjobs; i++) {
			st = new StringTokenizer(f.readLine());
			jobs[i] = new job(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(jobs);
		long total = 0;
		long time = 0;
		for (int i = 0; i < numjobs; i++) {
			time += jobs[i].length;
			total += time * jobs[i].weight;
		}

		// System.out.println(Arrays.toString(jobs));
		System.out.println(total);
		f.close();
	}
}
