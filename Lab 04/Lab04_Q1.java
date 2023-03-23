import java.util.Scanner;

/**
 * Lab04_Q1
 */
public class Lab04_Q1 {

    public static void main(String[] args) {
    	final double DAYS_IN_YEAR = 365.0;
    	
        Scanner userIn = new Scanner( System.in );
        
        int days,
        	min_people,
        	max_people;
        double probability;
        
        //input the min and max people
        do {
        	System.out.print( "Enter the minimum and maximum number of people: " );
        	min_people = userIn.nextInt();
        	max_people = userIn.nextInt();
        	if ( min_people >= max_people ){
        		System.out.println( "Invalid input - minimum must be less than maximum..." );
        	}
        }while ( min_people >= max_people );
        userIn.close();
               
        //display table heading
        System.out.printf( "%-20s %6s%n","NUMBER OF PEOPLE", "PROBABILITY" );
        
        //initialize probability before entering loop
        probability = 1;
		//for each group 
        for ( int groupSize = min_people; groupSize <= max_people; groupSize++ ){

        	//calculate the probability for the given group size
        	for ( int j = 1; j < groupSize; j++ ){
        		probability = probability * ((DAYS_IN_YEAR - j)/DAYS_IN_YEAR);
        	}
        	probability = 1 - probability;
        	System.out.printf( "%-20d%6.3f %n",groupSize,probability );
        	//reset probability to starting value
        	probability = 1;
        }
        
    }
}