package scam;

import java.util.Arrays;
import java.util.Scanner;

class box implements Comparable<box>
{
	int w, d, h;

	public box(int h, int d, int w)
	{
		this.w = w;
		this.d = d;
		this.h = h;
	}

	public int compareTo(box b)
	{
		return b.w * b.d - w * d;
	}

}

public class boxstacking
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		box[] boxes = new box[scan.nextInt() * 3];

		for (int i = 0; i < boxes.length; i++)
		{
			int w = scan.nextInt(), d = scan.nextInt(), h = scan.nextInt();
			boxes[i] = new box(h, Math.min(w, d), Math.max(w, d));
			i++;
			boxes[i] = new box(w, Math.min(h, d), Math.max(h, d));
			i++;
			boxes[i] = new box(d, Math.min(h, w), Math.max(h, w));
		}

		Arrays.sort(boxes);

		int[] stackheight = new int[boxes.length];
		stackheight[0] = boxes[0].h;
		int total = 0;
		for (int i = 1; i < boxes.length; i++)
		{
			int max = 0;
			for (int j = 0; j < i; j++)
				if (max < stackheight[j] && boxes[j].w > boxes[i].w && boxes[j].d > boxes[i].d)
					max = stackheight[j];
			stackheight[i] = boxes[i].h + max;
			if (total < stackheight[i])
				total = stackheight[i];
		}

		System.out.println(total);

		scan.close();
	}
}
