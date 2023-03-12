/**
 * @(#)Lab02_Q1.java
 *
 *
 * @author 
 * @version 1.00 2023/03/08
 */
import java.util.Scanner;

public class Lab02_Q1 {
   
    public static void main(String[] args) {
        double x;
		double result;

		Scanner sc = new Scanner(System.in);
		
		// input the number from the user
		System.out.print("Enter a real number:  ");
		if ( !sc.hasNextDouble() ) {
			System.out.println( "Invalid input - value must be numeric...." );
			System.out.printf( "You entered: %s %n", sc.nextLine());
		} 
		else {

			x = sc.nextDouble();
			System.out.println("-------------------------------------------------");
			
			// based on entered number calculate the result
			if ( x > 15 ) {
				result = Math.sqrt( Math.pow(x,5) + 1 );	
			}
			else if ( x <= 15 && x >= 0 ) {
				result =  Math.exp(x) - 15;
			}
			else {
				result =  x / (x + 10);
			}
			//Output result
			System.out.printf ("f(x) = %.2f%n" , result);
		}
		//close the Scanner
		sc.close();
    }
}
