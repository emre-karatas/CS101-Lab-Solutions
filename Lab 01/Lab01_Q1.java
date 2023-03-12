import java.util.Scanner;

public class Lab01_Q1 {
    public static void main(String[] args) {
		
		double x;
        double y;

		Scanner input = new Scanner( System.in );
        
		System.out.print("Enter x: ");
		x = input.nextInt();
		
		input.close();

		y = (Math.pow(x,3) + 3 * Math.abs(x) + 9)/Math.pow(x,2);
		System.out.println("y = "+ Math.round(y));
		System.out.printf("%f is between %.0f and %.0f %n", y, Math.floor( y), Math.ceil(y) );
	}
}
