package CodeSamples;

import java.util.ArrayList;
import java.util.Arrays;

// greedy
class ActivitySelection {
	private static class Activity implements Comparable<Activity> {
		int start;
		int finish;

		public Activity(int s, int f) {
			start = s;
			finish = f;
		}

		public int compareTo(Activity other) {
			return other.finish - finish;
		}
	}

	public static void selectActivities(int[] start, int[] finish) {
		Activity[] activities = new Activity[start.length];
		for (int i = 0; i < activities.length; i++) {
			activities[i] = new Activity(start[i], finish[i]);
		}

		Arrays.sort(activities);

		int max = 1;
		ArrayList<Integer> activityList = new ArrayList<>();
		int time = activities[0].finish;
		activityList.add(0);
		for (int i = 1; i < activities.length; i++) {
			if (time < activities[i].start) {
				time = activities[i].finish;
				activityList.add(i);
				max++;
			}
		}

		System.out.println(max);
		for (int activity : activityList) {
			System.out.print(activity + " ");
		}
	}
}
