/**
 * These classes describe people
 * 
 * @author Jusitn Kim
 */
package CSA;

public class Unitz10Lab1 {
	public static void main(String[] args) {
		Person percy = new Person("Percy Doe", "12345 Penn Ave", "p.doe@yahoo.com", "(812) 912-1283",
				new Date(1, 2, 3));
		Person sam = new Student("Sam Doe", "12345 Penn Ave", "s.doe@yahoo.com", "(812) 456-1345", new Date(12, 4, 512),
				"Freshman");
		Person edward = new Employee("Edward Doe", "12345 Penn Ave", "e,doe@gmail.com", "(812) 672-3781",
				new Date(5, 2, 123), 61.2, new Date(12, 4, 512));
		Person fred = new Faculty("Fred Doe", "12345 Penn Ave", "f.doe@gmail.com", "(812) 364-1232", new Date(4, 2, 12),
				10.2, new Date(12, 4, 512), "10-5", "professor");
		Person sean = new Staff("Sean Doe", "12345 Penn Ave", "s.doe@outlook.com", "(812) 124-5822",
				new Date(5, 23, 51), 12.4, new Date(12, 4, 512), "Dr.");

		System.out.println(percy);
		System.out.println(sam);
		System.out.println(edward);
		System.out.println(fred);
		System.out.println(sean);
	}
}

class Person {
	private String name;
	private String address;
	private String emailAddress;
	private String phoneNumber;
	private Date birthday;

	public Person(String name, String address, String emailAddress, String phoneNumber, Date birthday) {
		this.name = name;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	//returns name
	public String getName() {
		return name;
	}

	//sets name
	public void setName(String name) {
		this.name = name;
	}

	//returns address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person: " + name;
	}
}

class Student extends Person {
	private String status;

	public Student(String name, String address, String emailAddress, String phoneNumber, Date birthday, String status) {
		super(name, address, emailAddress, phoneNumber, birthday);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student: " + getName();
	}
}

class Employee extends Person {
	private double salary;
	private Date hiredDate;

	public Employee(String name, String address, String emailAddress, String phoneNumber, Date birthday, double salary,
			Date hiredDate) {
		super(name, address, emailAddress, phoneNumber, birthday);
		this.setSalary(salary);
		this.setHiredDate(hiredDate);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	@Override
	public String toString() {
		return "Employee: " + getName();
	}
}

class Faculty extends Employee {
	private String hours;
	private String rank;

	public Faculty(String name, String address, String emailAddress, String phoneNumber, Date birthday, double salary,
			Date hiredDate, String hours, String rank) {
		super(name, address, emailAddress, phoneNumber, birthday, salary, hiredDate);
		this.setHours(hours);
		this.setRank(rank);
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Faculty: " + getName();
	}
}

class Staff extends Employee {
	private String title;

	public Staff(String name, String address, String emailAddress, String phoneNumber, Date birthday, double salary,
			Date hiredDate, String title) {
		super(name, address, emailAddress, phoneNumber, birthday, salary, hiredDate);
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff: " + getName();
	}
}

class Date {
	private int month;
	private int day;
	private int year;

	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}