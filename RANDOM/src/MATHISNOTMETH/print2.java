import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class print2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("src/print2.java"));
		ArrayList<String> file = new ArrayList<String>();
		while (f.ready())
			file.add(f.readLine());
		f.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/print2.java")));

		@SuppressWarnings( { "unchecked", "unused" })
		int count = 5;
		for (String a : file) {
			if (a.length() > 14 && a.substring(0, 14).equals("		int count = "))
				out
						.println(a.substring(0, 14)
								+ (Integer.parseInt(a.substring(14,
										a.length() - 1)) + 1) + ";");
			else
				out.println(a);

		}
		out.close();
		for (String s : file)
			System.out.println(s);
	}
}
