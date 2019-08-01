
/*
ID: juskim81
LANG: JAVA
TASK: crypt1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class crypt1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numDigits = Integer.parseInt(st.nextToken());
		boolean[] digits = new boolean[10];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numDigits; i++) {
			digits[Integer.parseInt(st.nextToken())] = true;
		}

		// _________d1 d2 d3
		// ____________d4 d5
		// _________d6 d7 d8
		// ____d9 d10 d11
		// ___d12 d13 d14 d15

		int count = 0;
		for (int d1 = 0; d1 < 10; d1++) {
			if (digits[d1]) {
				for (int d2 = 0; d2 < 10; d2++) {
					if (digits[d2]) {
						for (int d3 = 0; d3 < 10; d3++) {
							if (digits[d3]) {
								for (int d4 = 0; d4 < 10; d4++) {
									if (digits[d4]) {
										for (int d5 = 0; d5 < 10; d5++) {
											if (digits[d5]) {
												int d8 = (d3 * d5) % 10;
												int car = d3 * d5 / 10;
												if (digits[d8]) {
													int d7 = (d2 * d5 + car) % 10;
													car = (d2 * d5 + car) / 10;
													if (digits[d7]) {
														int d6 = (d1 * d5 + car) % 10;
														car = (d1 * d5 + car) / 10;
														if (digits[d6]) {
															if (car == 0) {
																int d11 = (d3 * d4) % 10;
																car = d3 * d4 / 10;
																if (digits[d11]) {
																	int d10 = (d2 * d4 + car) % 10;
																	car = (d2 * d4 + car) / 10;
																	if (digits[d10]) {
																		int d9 = (d1 * d4 + car) % 10;
																		car = (d1 * d4 + car) / 10;
																		if (digits[d9]) {
																			if (car == 0) {
																				int d15 = d8;
																				if (digits[d15]) {
																					int d14 = (d7 + d11) % 10;
																					car = (d7 + d11) / 10;
																					if (digits[d14]) {
																						int d13 = (d6 + d10 + car) % 10;
																						car = (d6 + d10 + car) / 10;
																						if (digits[d13]) {
																							int d12 = (d9 + car) % 10;
																							car = (d9 + car) / 10;
																							if (digits[d12]) {
																								if (car == 0) {
																									count++;
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		out.println(count);
		out.close();
		f.close();
	}
}
