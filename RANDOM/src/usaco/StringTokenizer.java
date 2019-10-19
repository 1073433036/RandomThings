package usaco;

public class StringTokenizer {
	String line;
	String[] splitLine;
	int ind = 0;

	public StringTokenizer(String nextLine) {
		line = nextLine;
		splitLine = line.split(" ");
	}

	public String nextToken() {
		if (PrintWriter.startTime == -1) {
			PrintWriter.startTime = System.currentTimeMillis();
		}
		return splitLine[ind++];
	}

}
