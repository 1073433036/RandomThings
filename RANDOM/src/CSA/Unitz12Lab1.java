/**
 * This program has grocery items
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.ArrayList;
import java.util.Random;

public class Unitz12Lab1 {
	public static void main(String[] args) {
		Random rngen = new Random();
		GroceryItem[] grocery = new GroceryItem[50];

		for (int i = 0; i < grocery.length; i++) {
			grocery[i] = new GroceryItem(i, rngen.nextInt(30) + 1);
		}

		ArrayList<GroceryItem> less7 = new ArrayList<>();
		ArrayList<GroceryItem> greater7 = new ArrayList<>();
		for (int i = 0; i < grocery.length; i++) {
			if (grocery[i].getShelfLife() <= 7) {
				less7.add(grocery[i]);
			}
			else {
				greater7.add(grocery[i]);
			}
		}

		System.out.println("less than or 7 days of shelf life: " + less7.size());
		for (GroceryItem item : less7) {
			System.out.println(item);
		}
		System.out.println("greater than 7 days of shelf life: " + greater7.size());
		for (GroceryItem item : greater7) {
			System.out.println(item);
		}
	}
}

class GroceryItem {
	private int itemCode;
	private int shelfLife;

	public GroceryItem(int itemCode, int shelfLife) {
		this.setItemCode(itemCode);
		this.setShelfLife(shelfLife);
	}

	// returns item code
	public int getItemCode() {
		return itemCode;
	}

	// sets item code
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	// returns shelf life
	public int getShelfLife() {
		return shelfLife;
	}

	// if 1-30 sets shelf life
	public void setShelfLife(int shelfLife) {
		if (shelfLife > 0 && shelfLife <= 30)
			this.shelfLife = shelfLife;
	}

	@Override
	public String toString() {
		return itemCode + " " + shelfLife;
	}

}