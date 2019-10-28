package Math;
import java.util.Scanner;
public class QuadraticFormula {
	public static void main(String args[])
	{
		double a,b,c;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter a: ");
		a=scan.nextDouble();
		System.out.print("Enter b: ");
		b=scan.nextDouble();
		System.out.print("Enter c: ");
		c=scan.nextDouble();

		double ans1=Math.sqrt(b*b-4*a*c);
		double ans2=(-b+ans1)/(2*a);
		double ans3=(-b-ans1)/(2*a);
		System.out.println("The solutions are: " +ans2+" and " +ans3);
		scan.close();
	}
}
