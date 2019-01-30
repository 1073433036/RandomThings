/**
 * This program has a job queue
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Unitz12Lab2 {
	public static void main(String[] args) {
		Random rngen = new Random();
		Scanner input = new Scanner(System.in);

		LinkedList<Job> jobQueue = new LinkedList<>();
		boolean quit = false;
		while (!quit) {
			System.out.print("quit (true/false): ");
			boolean choice = input.nextBoolean();
			if (choice) {
				quit = true;
			}
			else {
				jobQueue.add(new Job(jobQueue.size(), rngen.nextInt(991) + 10));
			}
		}

		for (Job job : jobQueue) {
			System.out.println(job);
		}

		input.close();
	}
}

class Job {
	private int number;
	private int printTime;

	public Job(int number, int printTime) {
		this.setNumber(number);
		this.setPrintTime(printTime);
	}

	// returns job number
	public int getNumber() {
		return number;
	}

	// sets job number
	public void setNumber(int number) {
		this.number = number;
	}

	// returns print time
	public int getPrintTime() {
		return printTime;
	}

	// sets print time
	public void setPrintTime(int printTime) {
		this.printTime = printTime;
	}

	public String toString() {
		return number + " " + printTime;
	}
}