package scam;

public class postfrompreandinorders {
	static String in = "XRQFEASZDCBJGKHRMNLYPIOTU";
	static String pre = "BAEFRXQCDSZKGJMRHYLNIPOTU";

	static String post = "";

	public static void main(String[] args) {
		post(in, pre);
		System.out.println(post);
		post = "";
		postindices(0, in.length() - 1, 0, pre.length() - 1);
		System.out.println(post);
	}

	public static void postindices(int ins, int ine, int pres, int pree) {
		if (ins == ine) {
			post += in.charAt(ins);
			return;
		}
		if (ins > ine || pres > pree) {
			return;
		}
		char target = pre.charAt(pres);
		int ind = in.indexOf(target, ins);

		postindices(ins, ind - 1, pres + 1, pres + ind - ins);
		postindices(ind + 1, ine, pres + ind - ins + 1, pree);
		post += pre.charAt(pres);
	}

	public static void post(String in, String pre) {
		if (in.length() == 0) {
			return;
		}
		char first = pre.charAt(0);
		int ind = in.indexOf(first);
		String s1 = in.substring(0, ind);
		String s2 = pre.substring(1, s1.length() + 1);
		String s3 = in.substring(ind + 1);
		String s4 = pre.substring(s1.length() + 1);
		post(s1, s2);
		post(s3, s4);
		post += first;
	}
}
