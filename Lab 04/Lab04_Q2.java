import java.util.Scanner;

/**
 * Lab04_Q2
 */
public class Lab04_Q1 {

    public static void main(String[] args) {
        final String LABEL = "review";

        String chartData;
        int maxDigit;
        int sum;
        int pos;

        double average;

        //input chart data as a string
        Scanner input = new Scanner( System.in );
        System.out.print("Enter chart data: ");
        chartData = input.next();
        input.close();
    
        //validate that string only contains digits
        pos = -1;
        do {
            pos++;
        }while( pos < chartData.length() && Character.isDigit(chartData.charAt(pos)));
        
        //if the string does not contain only digits 
        if ( pos != chartData.length() ){
            System.out.println("Invalid chart data!");
        }
        else {
            //display chart headings
            for (int i = 1; i <= chartData.length(); i++){
                System.out.printf("%10s",LABEL+" "+i);
            }
            System.out.println();

            //find max digit (tallest bar) and average digit
            maxDigit = -1;
            sum = 0;
            for ( int i = 0; i < chartData.length(); i++ ){
                int current = Character.getNumericValue(chartData.charAt(i));
                if (  current > maxDigit ){
                    maxDigit = current; 
                }
                sum += current;
            }
            //calculate average bar height
            average = (double)sum / chartData.length();

            //for each line
            for ( int line = maxDigit; line > 0; line-- ){
                
                //for each digit in the string
                for( int ch = 0; ch < chartData.length(); ch++ ){

                    //if the value of the current digit is greater than or equal to the current line 
                    int current = Character.getNumericValue( chartData.charAt( ch ) );
                    if ( current >= line ){
                        //print 3 stars
                        System.out.printf("%10s","***");
                    }
                    else {
                        //print empty space
                        System.out.printf("%10s","");
                    }
                }
                //go to the next line
                System.out.println();
            }
            System.out.printf("Average Review: %.1f%n",average );
        }
    }
}