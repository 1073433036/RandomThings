//package usacoFinished;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class Secret_Code_2014FebSilver3 {

	static HashMap<String, Integer> count = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("scode.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scode.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		String pass = st.nextToken();

		out.println(solve(pass) - 1);
		f.close();
		out.close();
	}

	public static int solve(String password) {
		if (count.containsKey(password)) {
			return count.get(password);
		}

		int total = 1;
		for (int i = 1; i < password.length() / 2.0; i++) {
			if (password.substring(0, i).equals(password.substring(i, 2 * i))) {
				int ans = solve(password.substring(i)) % 2014;
				count.put(password.substring(i), ans);
				total += ans;
			}
			if (password.substring(0, i).equals(password.substring(password.length() - i))) {
				int ans = solve(password.substring(i)) % 2014;
				count.put(password.substring(i), ans);
				total += ans;
				ans = solve(password.substring(0, password.length() - i)) % 2014;
				count.put(password.substring(0, password.length() - i), ans);
				total += ans;
			}
			if (password.substring(password.length() - 2 * i, password.length() - i)
					.equals(password.substring(password.length() - i))) {
				int ans = solve(password.substring(0, password.length() - i)) % 2014;
				count.put(password.substring(0, password.length() - i), ans);
				total += ans;
			}
		}

		return total % 2014;
	}
}
