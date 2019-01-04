/**
 * This is a person class
 * @author Justin Kim
 */

package CSA;

public class Unit9Lab1 {
	public static void main(String[] args) {
		Person1 tony = new Person1("Tony", "Baggadonuts", new Date1(10, 21, 2001));

		System.out.println("Name: " + tony.getFirstName() + " " + tony.getLastName());
		System.out.println("Birthday: " + tony.getBirthday());
	}
}

class Person1 {
	private Name name;
	private Date1 birthday;

	public Person1(String firstName, String lastName, Date1 birthday) {
		this.name = new Name(firstName, lastName);
		this.setBirthday(birthday);
	}

	public Person1() {
		name = new Name("None", "None");
		setBirthday(new Date1(0, 0, 0));
	}

	// precondition: name and first name defined
	// postcondition: returns first name
	public String getFirstName() {
		return name.getFirstName();
	}

	// precondition: firstName defined
	// postcondition: sets first name
	public void setFirstName(String firstName) {
		name.setFirstName(firstName);
	}

	// precondition: last name defined
	// postcondition: returns last name
	public String getLastName() {
		return name.getLastName();
	}

	// precondition: lastName defined
	// postcondition: sets last name
	public void setLastName(String lastName) {
		name.setLastName(lastName);
	}

	// precondition: birthday defined
	// postcondition: returns birthday date
	public Date1 getBirthday() {
		return birthday;
	}

	// precondition: birthday defined
	// postcondition: sets birthday
	public void setBirthday(Date1 birthday) {
		this.birthday = birthday;
	}
}

class Name {
	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	// precondition: first name defined
	// postcondition: returns first name
	public String getFirstName() {
		return firstName;
	}

	// precondition: firstName defined
	// postcondition: sets first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// precondition: last name defined
	// postcondition: returns last name
	public String getLastName() {
		return lastName;
	}

	// precondition: lastName defined
	// postcondition: sets last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
