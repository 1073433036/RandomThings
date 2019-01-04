/**
 * This is a inheritance structure for objects
 * 
 * @author Justin Kim
 * 
 */

package CSA;

public class Unitz11Lab2_ManipulateAnimals {
	public static void main(String[] args) {
		Thing[] things = { new Animal("cow"), new Animal("pig"), new Vehicle("GMC", 2), new Vehicle("Ford", 1) };
		for (int i = 0; i < 4; i++) {
			System.out.println(things[i].getName());
			things[i].drawObject();
			things[i].playSound();
			things[i].resizeObject();
			things[i].resizeObject();
		}
	}

}

abstract class Thing implements Drawable, Rotatable, Resizeable, Sounds {
	protected String name;

	// returns name
	public String getName() {
		return name;
	}

	// sets name
	public void setName(String name) {
		this.name = name;
	}

}

class Animal extends Thing {

	public Animal(String name) {
		this.name = name;
	}

	// prints message
	@Override
	public void playSound() {
		System.out.println("Animal Sound");
	}

	// prints message
	@Override
	public void resizeObject() {
		System.out.println("Resizing an Animal");
	}

	// prints message
	@Override
	public void rotateObject() {
		System.out.println("Rotating an Animal");
	}

	// prints message
	@Override
	public void drawObject() {
		System.out.println("Drawing an Animal");
	}
}

class Vehicle extends Thing {
	private int age;

	public Vehicle(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// prints message
	@Override
	public void playSound() {
		System.out.println("Vehicle Sound");
	}

	// prints message
	@Override
	public void resizeObject() {
		System.out.println("Resizing an Vehicle");
	}

	// prints message
	@Override
	public void rotateObject() {
		System.out.println("Rotating an Vehicle");
	}

	// prints message
	@Override
	public void drawObject() {
		System.out.println("Drawing an Vehicle");
	}

	// returns age
	public int getAge() {
		return age;
	}

	// sets age
	public void setAge(int age) {
		this.age = age;
	}

}

interface Drawable {
	void drawObject();
}

interface Rotatable {
	void rotateObject();
}

interface Resizeable {
	void resizeObject();
}

interface Sounds {
	void playSound();
}