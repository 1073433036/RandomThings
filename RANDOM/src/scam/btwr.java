package scam;

public class btwr
{
	public static void main(String[] args)
	{
		
	}
}

// package scam;
//
// import java.util.Arrays;
// import java.util.Scanner;
//
// class bale implements Comparable<bale>
// {
// int width, height;
//
// public bale(int width, int height)
// {
// this.width = width;
// this.height = height;
// }
//
// public int compareTo(bale o)
// {
// return o.width - this.width;
// }
//
// }
//
// public class btwr
// {
// public static void main(String[] args)
// {
// Scanner scan = new Scanner(System.in);
// int balenum = scan.nextInt();
//
// bale[] bales = new bale[balenum];
// bale[] altbales = new bale[balenum];
// for (int i = 0; i < balenum; i++)
// {
// int width = scan.nextInt(), height = scan.nextInt();
// bales[i] = new bale(width, height);
// altbales[i] = new bale(height, width);
// }
//
// // reverse order by width
// Arrays.sort(bales);
// int max = balenum;
// bale last = bales[0];
// for (int i = 1; i < balenum; i++)
// {
// if (last.height < bales[i].height)
// max--;
// else
// last = bales[i];
// }
//
// // reverse order by height
// Arrays.sort(altbales);
// int altmax = balenum;
// last = altbales[0];
// for (int i = 1; i < balenum; i++)
// if (last.width < altbales[i].width)
// max--;
// else
// last = altbales[i];
//
// System.out.print(max > altmax ? max : altmax);
//
// scan.close();
// }
// }
