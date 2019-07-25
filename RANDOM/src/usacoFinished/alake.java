package usacoFinished;

import java.util.ArrayList;
import java.util.Scanner;

public class alake {
	private static class level {
		int width;
		int height;
		int actualPos;

		public level(int w, int h, int ap) {
			width = w;
			height = h;
			actualPos = ap;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numLevels = scan.nextInt();
		ArrayList<level> levels = new ArrayList<>(numLevels + 2);
		int minHeight = 0x3f3f3f3f;
		int minInd = 0;
		levels.add(new level(0, 10000000, 0));
		for (int i = 1; i <= numLevels; i++) {
			levels.add(new level(scan.nextInt(), scan.nextInt(), i));
			if (minHeight > levels.get(i).height) {
				minInd = i;
				minHeight = levels.get(i).height;
			}
		}
		levels.add(new level(0, 10000000, levels.size() - 1));

		long[] times = new long[numLevels + 1];
		long curTime = 0;
		while (levels.size() > 3) {// INF level INF
			curTime += levels.get(minInd).width;
			times[levels.get(minInd).actualPos] = curTime;
			if (levels.get(minInd - 1).height < levels.get(minInd + 1).height) {
				// go left
				curTime += levels.get(minInd).width * (levels.get(minInd - 1).height - levels.get(minInd).height - 1l);
				levels.get(minInd - 1).width += levels.get(minInd).width;
				levels.remove(minInd--);
				while (levels.get(minInd - 1).height < levels.get(minInd).height) {
					minInd--;
				}
			}
			else {
				// go right
				curTime += levels.get(minInd).width * (levels.get(minInd + 1).height - levels.get(minInd).height - 1l);
				levels.get(minInd + 1).width += levels.get(minInd).width;
				levels.remove(minInd);
				while (levels.get(minInd + 1).height < levels.get(minInd).height) {
					minInd++;
				}
			}
		}
		curTime += levels.get(minInd).width;
		times[levels.get(minInd).actualPos] = curTime;

		for (int i = 1; i <= numLevels; i++) {
			System.out.println(times[i]);
		}
		scan.close();
	}
}
