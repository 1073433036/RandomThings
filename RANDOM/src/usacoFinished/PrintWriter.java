package usacoFinished;

public class PrintWriter {
	public static long startTime = -1;

	public PrintWriter(BufferedWriter str) {
	}

	public void println(Object a) {
		System.out.println(a);
	}

	public void print(Object a) {
		System.out.print(a);
	}

	public void close() {
		System.out.println("Program took " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	public void println() {
		System.out.println();
	}
}
