package TRULYRANDOM;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class hello {
	public static void main(String[] args) throws IOException {
		int a = 3;
		int b = 21;
		int less = Math.min(a, b);
		int sum = a + b;
		double half = sum / 2;
		double ckpow2 = half / less;
		System.out.println(ckpow2);
	}
}
