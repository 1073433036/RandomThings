/**
 * this is a program that shows the subscriber/publisher design
 * 
 * @author Justin Kim
 */

package CSA;

public class Unitz10Lab3_TestPattern {
	public static void main(String[] args) {
		// Create Publisher & Subscriber objects
		MySubscriber sub1 = new MySubscriber();
		MySubscriber sub2 = new MySubscriber();
		MySubscriber sub3 = new MySubscriber();
		MyPublisher aPublisher = new MyPublisher(3);
		// Register a Subscriber
		aPublisher.register(sub1);
		aPublisher.register(sub2);
		aPublisher.register(sub3);
		// Increment Publisher object to cause state changes
		aPublisher.increment();
		aPublisher.increment();
		aPublisher.increment();
		aPublisher.increment();
	}
}

class MySubscriber extends Subscriber {

	@Override
	public void update(int subNum) {
		System.out.println("Subscriber " + subNum + " has been notified.");
	}
}

class MyPublisher extends Publisher {
	private int count;

	public MyPublisher(int mx) {
		super(mx);
		count = 0;
	}

	public void increment() {
		count++;
		// Notify subscribers if count >= 3
		if (count >= 3)
			notifySubscribers();
	}
}

class Publisher {
	private Subscriber[] subscriberList;
	private int maximumSubscribers;
	private int nextIndex;

	public Publisher(int max) {
		// An array stores subscribers
		// Maximum number of subscribers
		// Array index of next subscriber
		// Initialize attributes & create subscriber array
		maximumSubscribers = max;
		subscriberList = new Subscriber[maximumSubscribers];
		nextIndex = 0;
	}

	public void register(Subscriber s) {
		// Register a subscriber unless the subscriber array is full
		if (nextIndex < maximumSubscribers)
			subscriberList[nextIndex++] = s;
		else
			System.out.println("ERROR: Subscriber List is full");
	}

	public void notifySubscribers() {
		// Iterate through the subscriber array & invoke update() methods
		for (int i = 0; i < nextIndex; i++)
			subscriberList[i].update(i);
	}
}

class Subscriber {
	public void update(int subNum) {
		System.out.println("Notified of state change");
	}
}
