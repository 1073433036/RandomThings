/**
 * This program displays dates
 * 
 * @author Justin Kim
 */

package CSA;

import javax.swing.JOptionPane;

public class Unit9Activity1_DateExercise {
	public static void main(String[] args) {
		Date1 date = new Date1(Input.getInt("Input the year: "), Input.getInt("Input the month: "),
				Input.getInt("Input the day: "));

		date.displayDate();
	}
}

class Date1 {
	private int month = 1;
	private int day = 1;
	private int year = 2000;

	public Date1(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	// precondition: month, day, year all defined
	// postcondition: displays date in box
	public void displayDate() {
		JOptionPane.showMessageDialog(null, "The date is " + getMonth() + "/" + getDay() + "/" + getYear());
	}

	// precondition: month defined
	// postcondition: returns month
	public int getMonth() {
		return month;
	}

	// precondition: month is 1-12
	// postcondition: sets month
	public void setMonth(int month) {
		if (month <= 0 || month > 12) {
			throw new IllegalArgumentException("month must be 1-12");
		}

		this.month = month;
	}

	// precondition: day defined
	// postcondition: returns day
	public int getDay() {
		return day;
	}

	// precondition: day is within limits of month
	// postcondition: sets day
	public void setDay(int day) {
		int maxDay = 31;
		if (month == 9 || month == 4 || month == 6 || month == 11) {
			maxDay = 30;
		}
		else if (month == 2) {
			maxDay = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 29 : 28;
		}

		if (day <= 0 || day > maxDay) {
			throw new IllegalArgumentException("day must be 1-" + maxDay);
		}

		this.day = maxDay;
	}

	// precondition: year defined
	// postcondition: returns year
	public int getYear() {
		return year;
	}

	// precondition: year is int
	// postcondition: sets year
	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return getMonth() + "/" + getDay() + "/" + getYear();
	}
}
