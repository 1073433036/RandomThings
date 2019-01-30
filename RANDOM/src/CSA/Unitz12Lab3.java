/**
 * this is a contact list
 * 
 * @author Justin Kim
 */

package CSA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Unitz12Lab3 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("File name: ");
		String fileName = input.nextLine();
		BufferedReader f = new BufferedReader(new FileReader(fileName + ".txt"));
		StringTokenizer st;

		TreeMap<String, Contact> contactList = new TreeMap<>();

		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			String firstName = st.nextToken();
			String lastName = st.nextToken();
			String phoneNumber = st.nextToken();
			String emailAddress = st.nextToken();
			contactList.put(lastName, new Contact(firstName, lastName, phoneNumber, emailAddress));
		}

		for (int i = 0; i < 4; i++) {
			System.out.print("1:add, 2: delete, 3: display  : ");
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
				case 1:
					System.out.print("First name: ");
					String firstName = input.nextLine();
					System.out.print("last name: ");
					String lastName = input.nextLine();
					System.out.print("phone number: ");
					String phoneNumber = input.nextLine();
					System.out.print("email address: ");
					String emailAddress = input.nextLine();
					contactList.put(lastName, new Contact(firstName, lastName, phoneNumber, emailAddress));
					break;
				case 2:
					contactList.remove(input.nextLine().trim());
					break;
				case 3:
					for (String contact : contactList.keySet()) {
						System.out.println(contactList.get(contact));
					}
					break;
			}
		}
		f.close();
		input.close();

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt")));
		for (String contact : contactList.keySet()) {
			out.println(contactList.get(contact));
		}

		out.close();
	}

}

class Contact {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;

	public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
	}

	// returns first name
	public String getFirstName() {
		return firstName;
	}

	// sets first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// returns last name
	public String getLastName() {
		return lastName;
	}

	// sets last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// returns phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// sets phone number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// returns email address
	public String getEmailAddress() {
		return emailAddress;
	}

	// returns email address
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String toString() {
		return firstName + " " + lastName + ": " + phoneNumber + " " + emailAddress;
	}
}