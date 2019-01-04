/**
 * These classes hold the time in seconds since midnight and hours, minutes, and
 * seconds
 * 
 * @author Justin Kim
 */

package CSA;

public class Unit8Lab2_TestTime2 {
	public static void main(String[] args) {
		// 2:30.32
		Time2 secMid = new Time2(2, 30, 32);
		Time2Original hms = new Time2Original(2, 30, 32);

		System.out.println("Hour hms: " + hms.getHour());
		System.out.println("Hour secMid: " + secMid.getHour());
		System.out.println("Minute hms: " + hms.getMinute());
		System.out.println("Minute secMid: " + secMid.getMinute());
		System.out.println("Second hms: " + hms.getSecond());
		System.out.println("Second secMid: " + secMid.getSecond());
		System.out.println(hms.toString());
		System.out.println(hms.toUniversalString());
		System.out.println(secMid.toString());
		System.out.println(secMid.toUniversalString());
		System.out.println();

		hms.setHour(3);
		secMid.setHour(3);
		hms.setMinute(2);
		secMid.setMinute(2);
		hms.setSecond(1);
		secMid.setSecond(1);

		System.out.println("Hour hms: " + hms.getHour());
		System.out.println("Hour secMid: " + secMid.getHour());
		System.out.println("Minute hms: " + hms.getMinute());
		System.out.println("Minute secMid: " + secMid.getMinute());
		System.out.println("Second hms: " + hms.getSecond());
		System.out.println("Second secMid: " + secMid.getSecond());
		System.out.println(hms.toString());
		System.out.println(hms.toUniversalString());
		System.out.println(secMid.toString());
		System.out.println(secMid.toUniversalString());
	}
}

class Time2 {
	private long seconds;

	public Time2() {
		this(0, 0, 0);
	}

	public Time2(int hour) {
		this(hour, 0, 0);
	}

	public Time2(int hour, int minute) {
		this(hour, minute, 0);
	}

	public Time2(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public Time2(Time2 time) {
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public int getHour() {
		return (int) (seconds / 3600);
	}

	public void setHour(int hour) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}

		seconds = hour * 3600 + getMinute() * 60 + getSecond();
	}

	public int getMinute() {
		return (int) (seconds / 60 % 60);
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-60");
		}

		seconds = getHour() * 3600 + minute * 60 + getSecond();
	}

	public int getSecond() {
		return (int) (seconds % 60);
	}

	public void setSecond(int second) {
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-60");
		}

		seconds = getHour() * 3600 + getMinute() * 60 + second;
	}

	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	public String toString() {
		return String.format("%d:%02d:%02d %s", (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12, getMinute(),
				getSecond(), getHour() < 12 ? "AM" : "PM");

	}

}

class Time2Original {
	private int hour;
	private int minute;
	private int second;

	public Time2Original() {
		this(0, 0, 0);
	}

	public Time2Original(int hour) {
		this(hour, 0, 0);
	}

	public Time2Original(int hour, int minute) {
		this(hour, minute, 0);
	}

	public Time2Original(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public Time2Original(Time2Original time) {
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}

		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-60");
		}

		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-60");
		}

		this.second = second;
	}

	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	public String toString() {
		return String.format("%d:%02d:%02d %s", (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12, getMinute(),
				getSecond(), getHour() < 12 ? "AM" : "PM");

	}

}
