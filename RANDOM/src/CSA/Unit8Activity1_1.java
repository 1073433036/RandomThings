/**
 * This is a cat class simulator
 * 
 * @author Justin Kim
 */

package CSA;

public class Unit8Activity1_1 {
	public static void main(String[] args) {
		Cat catOne = new Cat();
		Cat catTwo = new Cat();

		catOne.setAge(10);
		catOne.setBreed("Tabby");
		catOne.setName("Orange");
		catOne.setSex('M');
		catOne.setWeight(10.0);
		System.out.println(catOne.getAge());
		System.out.println(catOne.getBreed());
		System.out.println(catOne.getName());
		System.out.println(catOne.getSex());
		System.out.println(catOne.getWeight());
		catOne.setAge(11);
		catOne.setName("Bob");
		System.out.println(catOne.getAge());
		System.out.println(catOne.getBreed());
		System.out.println(catOne.getName());
		System.out.println(catOne.getSex());
		System.out.println(catOne.getWeight());

		catTwo.setAge(1);
		catTwo.setBreed("Siamese");
		catTwo.setName("Shirt");
		catTwo.setSex('F');
		catTwo.setWeight(6.0);
		System.out.println(catTwo.getAge());
		System.out.println(catTwo.getBreed());
		System.out.println(catTwo.getName());
		System.out.println(catTwo.getSex());
		System.out.println(catTwo.getWeight());
		catTwo.setAge(2);
		catTwo.setWeight(6.5);
		System.out.println(catTwo.getAge());
		System.out.println(catTwo.getBreed());
		System.out.println(catTwo.getName());
		System.out.println(catTwo.getSex());
		System.out.println(catTwo.getWeight());
		catTwo.meow();
	}
}

class Cat {
	private String breed;
	private int age;
	private double weight;
	private char sex;
	private String name;

	public String eat() {
		return "Munch, Munch, Munch";
	}

	public String meow() {
		return "Meeeeeooww";
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}