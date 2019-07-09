package Metaprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProgramExponentialPrint {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("src/MATHISNOTMETH/ProgramExponentialPrint.java"));
		ArrayList<String> file = new ArrayList<String>();
		while (f.ready())
			file.add(f.readLine());
		f.close();
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter("src/MATHISNOTMETH/ProgramExponentialPrint.java")));
		for (String a : file) {
			if (a.equals("		for (String s : file)")) {
				out.println("		for (String s : file)");
				out.println("			System.out.println(s);");
			}
			out.println(a);

		}
		out.close();
		for (String s : file)
			System.out.println(s);
	}
}
