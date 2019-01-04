/**
 * This is a counter program
 * 
 * @author Justin Kim
 */

package CSA;

import javax.swing.JOptionPane;

public class Unit9Lab2_CounterTest {
	public static void main(String[] args) {
		CounterConsoleMenu console = new CounterConsoleMenu();
		boolean onward = true;
		while (onward) {
			console.displayChoices();
			switch (console.getInput()) {
				case 1:
					console.increment();
					break;
				case 2:
					console.decrement();
					break;
				case 3:
					console.reset();
					break;
				case 4:
					onward = false;
					break;
			}
			console.displayCounter();
		}
	}
}

class Counter {
	private int counter = 0;

	// precondition: counter defined
	// postcondition: add 1 to counter
	public void increment() {
		counter++;
	}

	// precondition: counter defined
	// postcondition: subtract 1 from counter
	public void decrement() {
		counter--;
	}

	// precondition: counter defined
	// postcondition: sets counter to 0
	public void reset() {
		counter = 0;
	}

	// precondition: counter defined
	// postcondition: returns counter
	public int getCounter() {
		return counter;
	}
}

class CounterConsoleMenu {
	private Counter counter;

	public CounterConsoleMenu() {
		counter = new Counter();
	}

	// precondition: defined
	// postcondition: displays options
	public void displayChoices() {
		JOptionPane.showMessageDialog(null, "1:increment\n2:decrement\n3:reset\n4:quit");
	}

	// precondition: input is 1-4
	// postcondition: returns input
	public int getInput() {
		int input = Input.getInt("Which option?");
		if (input < 1 || input > 4) {
			throw new IllegalArgumentException("1-4");
		}

		return input;
	}

	// precondition: counter defined
	// postcondition: displays counter
	public void displayCounter() {
		JOptionPane.showMessageDialog(null, "The counter is at: " + counter.getCounter());
	}

	// precondition: counter defined
	// postcondition: increments counter
	public void increment() {
		counter.increment();
	}

	// precondition: counter defined
	// postcondition: decrements counter
	public void decrement() {
		counter.decrement();
	}

	// precondition: counter defined
	// postcondition: resets counter
	public void reset() {
		counter.reset();
	}

}