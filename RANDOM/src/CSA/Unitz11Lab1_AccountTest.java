/**
 * This program simulates account types
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz11Lab1_AccountTest {
	public static void main(String[] args) {
		SavingsAccount s = new SavingsAccount("#1231212", 10, .01, new Date(1, 1, 1));
		CheckingAccount c = new CheckingAccount("#12312992", 10, .01, new Date(1, 1, 1), 2);

		System.out.println(s.getBalance());
		System.out.println(c.getBalance());
		s.deposit(10);
		s.deposit(5);
		c.deposit(1);
		c.deposit(4);
		System.out.println(s.getBalance());
		System.out.println(c.getBalance());
		s.withdraw(14);
		s.withdraw(5);// wont work
		c.withdraw(15);
		c.withdraw(2);// will work
		System.out.println(s.getBalance());
		System.out.println(c.getBalance());
	}
}

abstract class Account {
	protected String accountNumber;
	protected double balance;
	protected double annualInterestRate;
	protected Date dateCreated;

	public Account(String accountNumber, double balance, double annualInterestRate, Date dateCreated) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = dateCreated;
	}

	abstract void deposit(double amount);

	abstract void withdraw(double amount);

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
}

class SavingsAccount extends Account {

	public SavingsAccount(String accountNumber, double balance, double annualInterestRate, Date dateCreated) {
		super(accountNumber, balance, annualInterestRate, dateCreated);
	}

	// deposit money
	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	// withdraw money if doesn't go neg
	@Override
	public void withdraw(double amount) {
		if (balance >= amount)
			balance -= amount;
	}

}

class CheckingAccount extends Account {
	private double overdraftLimit;

	public CheckingAccount(String accountNumber, double balance, double annualInterestRate, Date dateCreated,
			double overdraftLimit) {
		super(accountNumber, balance, annualInterestRate, dateCreated);
		this.overdraftLimit = overdraftLimit;
	}

	// deposit money
	@Override
	void deposit(double amount) {
		balance += amount;
	}

	// withdraw money as long as not overdrawn over limit
	@Override
	void withdraw(double amount) {
		if (-balance <= overdraftLimit)
			balance -= amount;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}
}