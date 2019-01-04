/**
 * This program extends the counter with a memory function
 * 
 * @author Justin Kim
 */

package CSA;

import javax.swing.JOptionPane;

public class Unitz10Lab2_MemoryCounterTest {
	public static void main(String[] args) {
		MemoryCounterConsoleMenu console = new MemoryCounterConsoleMenu();
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
					console.displayMemory();
					break;
				case 5:
					console.addMemory();
					break;
				case 6:
					console.resetMemory();
					break;
				case 7:
					onward = false;
					break;
			}
			console.displayCounter();
		}
	}
}

class MemoryCounter extends Counter {
	private int memory = 0;

	public void resetMemory() {
		memory = 0;
	}

	public int getMemory() {
		return memory;
	}

	public void addMemory(int count) {
		memory += count;
	}

}

class MemoryCounterConsoleMenu {
	private MemoryCounter counter;

	public MemoryCounterConsoleMenu() {
		counter = new MemoryCounter();
	}

	// precondition: defined
	// postcondition: displays options
	public void displayChoices() {
		JOptionPane.showMessageDialog(null,
				"1:increment\n2:decrement\n3:reset\n4:display memory\n5:add memory\n6:reset memory\n7:quit");
	}

	// precondition: input is 1-4
	// postcondition: returns input
	public int getInput() {
		int input = Input.getInt("Which option?");
		if (input < 1 || input > 7) {
			throw new IllegalArgumentException("1-7");
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

	public void displayMemory() {
		JOptionPane.showMessageDialog(null, "The memory is at: " + counter.getMemory());
	}

	public void addMemory() {
		counter.addMemory(counter.getCounter());
	}

	public void resetMemory() {
		counter.resetMemory();
	}
}