package Metaprograms;

public class StackOverflowError {
	public static void main(String[] args) {
		dfs();
	}

	public static void dfs() {
		int[] asdf = new int[26*26];
		dfs();
	}
}
