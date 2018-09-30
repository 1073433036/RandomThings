/**
 * This program/class prints out a calendar
 */

package CSA;

import java.util.Scanner;

public class Unit5Lab2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a month (1-12): ");
		int month = input.nextInt();
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		printMonthCalendar(month, year);

		input.close();
	}

	private static int getStartDay(int m, int d, int y) {
		// Adjust month number & year to fit Zeller's numbering system
		if (m < 3) {
			m = m + 12;
			y = y - 1;
		}

		int k = y % 100;      // Calculate year within century
		int j = y / 100;      // Calculate century term
		int h = 0;            // Day number of first day in month 'm'

		h = (d + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

		// Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
		int dayNum = ((h + 5) % 7) + 1;

		return dayNum;
	}

	private static void printMonthCalendar(int month, int year) {
		printMonthHeader(month, year);
		printMonthBody(month, year);
	}

	private static void printMonthHeader(int month, int year) {
		System.out.println("\t" + getMonthName(month) + "\t" + year);
		System.out.println("-------------------------------------");
		System.out.println("  Sun  Mon  Tue  Wed  Thu  Fri  Sat");
	}

	private static void printMonthBody(int month, int year) {
		int dayOfWeek = getStartDay(month, 1, year) % 7;

		System.out.print("    ");
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("     ");
		}
		System.out.print(1);
		dayOfWeek++;
		if (dayOfWeek > 6) {
			dayOfWeek = 0;
			System.out.println();
		}
		for (int day = 2; day <= getNumDaysInMonth(month, year); day++) {
			if (day < 10) {
				System.out.print(" ");
			}

			System.out.print("   " + day);
			if (dayOfWeek == 6) {
				dayOfWeek = -1;
				System.out.println();
			}
			dayOfWeek++;
		}
	}

	private static String getMonthName(int month) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return months[month - 1];
	}

	private static int getNumDaysInMonth(int month, int year) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}

		if (month == 2) {
			return isLeapYear(year) ? 29 : 28;
		}

		return 31;
	}

	private static boolean isLeapYear(int year) {
		if (year % 100 == 0 && year % 400 != 0) {
			return false;
		}

		return year % 4 == 0;
	}
}
