/**
 * This class is for a rectangle
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unit8Lab1_TestRectangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rectangle rect = new Rectangle();

		//input rectangle dimensions
		System.out.print("length: ");
		rect.setLength(input.nextInt());
		System.out.print("width: ");
		rect.setWidth(input.nextInt());

		rect.draw(input.next().charAt(0));

		System.out.println("Area: " + rect.area());
		System.out.println("Perimeter: " + rect.perimeter());

		input.close();
	}
}

class Rectangle {
	private int length = 0;
	private int width = 0;

	//takes character to draw rectangle with and draws rectangle
	public void draw(char fillChar) {
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getLength(); j++) {
				System.out.print(fillChar);
			}
			System.out.println();
		}
	}

	//if length and width are defined, returns area
	public int area() {
		return getLength() * getWidth();
	}

	//if length and width are defined, returns perimeter
	public int perimeter() {
		return 2 * getLength() + 2 * getWidth();
	}

	//if length is defined, return length
	public int getLength() {
		return length;
	}

	//if length given is 1-30, set length
	public void setLength(int length) {
		if (length > 0 && length <= 30) {
			this.length = length;
		}
		else {
			System.out.println("NO");
		}
	}

	//if width is defined, return width
	public int getWidth() {
		return width;
	}

	//if width given is 1-30, set width
	public void setWidth(int width) {
		if (width > 0 && width <= 30) {
			this.width = width;
		}
		else {
			System.out.println("NO");
		}
	}
}