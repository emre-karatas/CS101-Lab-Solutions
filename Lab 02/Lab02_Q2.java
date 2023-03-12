/**
 * @(#)Jars
 *	Inputs number of large and small jars available and order size.
 *  Assumes a large jar is 5 litres and a small bar is 1 litre
 *  Outputs the number of small jars to use for the given package.
 *
 * @author 
 * @version 1.00 2023/03/08
 */
import java.util.Scanner;
public class Lab02_Q2{

    public static void main(String[] args) {
        //declare constants
        final int LARGE_JAR = 5;

        //declare variables
        int big;
		int small;
		int goal;
        int smallJars;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of small and large jars available and the order size: ");

        small = input.nextInt();
        big = input.nextInt();
        goal = input.nextInt();

		//close the Scanner
		input.close();

		if ( goal < LARGE_JAR ){
			//invalid input
        	System.out.println("The package must be larger than "+LARGE_JAR+"kg");
		}
		else {
			//if it can't be done
			if( ( small + big * LARGE_JAR  < goal ) || ( small < goal%LARGE_JAR ) || ( goal-(big*LARGE_JAR)  > small )){
				smallJars = -1;
			}
			//if you will use all big jars
			else if(goal>big*5){
			      smallJars = goal-big*5;
			}
			//not all big jars will be used
			else {
				 smallJars = goal%5;
			}
			//if there is the correct combination of jars
			if(smallJars != -1){
				 System.out.printf("Order of %d litres will contain %d small(1 litre) Jars", goal, smallJars );
			}
			else {
				System.out.println("You do not have enough jars to complete the order");
			}	
		}		
    }
}
