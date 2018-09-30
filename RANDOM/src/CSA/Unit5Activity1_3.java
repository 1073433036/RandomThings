/**
 * This class/program displays 20 random number between 1 and 5
 * 
 * @author JustinKim
 */

package CSA;

public class Unit5Activity1_3 {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println((int) (Math.random() * 5) + 1);
		}
	}
}
