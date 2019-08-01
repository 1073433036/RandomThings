package scam;

import java.util.Scanner;

public class polygonarea {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numPolygons = scan.nextInt();
		long max = 0;
		for (int i = 0; i < numPolygons; i++) {
			int numpts = scan.nextInt();
			long sx = scan.nextInt();
			long sy = scan.nextInt();

			long area = 0;
			long px = sx;
			long py = sy;
			for (int j = 1; j < numpts; j++) {
				long nx = scan.nextInt();
				long ny = scan.nextInt();
				area += px * ny - py * nx;
				px = nx;
				py = ny;
			}
			area += px * sy - py * sx;
			area = Math.abs(area) / 2;
			max = Math.max(max, area);
		}

		System.out.println(max);
		scan.close();
	}
}
