package Metaprograms;

public class StackOverflowError {
	public static void main(String[] args) {
		dfs();	// max times it will call is 1024 without parameters
	}

	public static void dfs() {
		int[] asdf = new int[26*26];
		dfs();
	}
}
