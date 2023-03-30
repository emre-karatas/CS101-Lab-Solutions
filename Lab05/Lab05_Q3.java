import java.util.Scanner;

/**
 * Lab05_Q3
 */
public class Lab05_Q3 {
    //private static Scanner input;
    public static void displayMenu(){
        System.out.println("1 - Find Probability of Same Birthday");
        System.out.println("2 - Draw Chart");
        System.out.println("3 - Convert Word");
        System.out.println( "4 - QUIT" );
        System.out.print("Enter choice: ");
    }
    public static int getChoice(){
        Scanner input = new Scanner(System.in);
        int choice;
        displayMenu();
        choice = input.nextInt();
        return choice;
    }
    public static double sameBirthday( int groupSize ){
        final int DAYS_IN_YEAR = 365;
        double probability;
        probability = 1;
        for ( int j = 1; j < groupSize; j++ ){
            probability = probability * ((DAYS_IN_YEAR - j)/DAYS_IN_YEAR);
        }
        probability = 1 - probability;
        return probability;
    }
    public static int findMax( String chartData ) {
        int maxDigit;
        
        maxDigit = -1;
        for ( int i = 0; i < chartData.length(); i++ ){
            int current = Character.getNumericValue(chartData.charAt(i));
            if (  current > maxDigit ){
                maxDigit = current; 
            }
        }
        return maxDigit;
    }
    public static void displayChart( String chartData ){
        int maxDigit;

        //display chart headings
        for (int i = 1; i <= chartData.length(); i++){
            System.out.printf("%10s","review"+" "+i);
        }
        System.out.println();

        //find max digit (tallest bar) and average digit
        maxDigit = findMax( chartData );

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
    }
    public static boolean isValidNumeric( String chartData ){
        int pos = -1;
        do {
            pos++;
        }while( pos < chartData.length() && Character.isDigit(chartData.charAt(pos)));
        
        //if the string does not contain only digits 
        if ( pos != chartData.length() ){
            return false;
        }
        return true;
    }
    public static int countLetter( String word, int ind ){
        int count;
        count = 1;
        for ( int j = 0; j < word.length(); j++){
            if( ind != j && Character.toUpperCase(word.charAt(ind)) == Character.toUpperCase(word.charAt(j))){
                count++;
            }
        }
        return count;
    }
    public static String convertWord( String word ){
        String newWord;
        int count;

        newWord = "";
        for( int i = 0; i < word.length(); i++){
            if ( !Character.isLetter(word.charAt(i)) ){
                newWord += '*';
            }
            else { 
                count = countLetter(word, i);
                if( count != 1 ){
                    newWord += ")";
                }
                else {
                    newWord += "(";
                }
            }
        }
        return newWord;
        
    }
    public static void main(String[] args) {
        int choice;
        int groupSize;
        double probability;
        String chartData;
        String word;
        String newWord;

        Scanner input = new Scanner( System.in );
        choice = getChoice();
        while ( choice != 4 ) {
            if ( choice == 1 ){
                System.out.print( "Enter the group size: " );
        	    groupSize = input.nextInt();
                probability = sameBirthday(groupSize);
                System.out.printf( "The probability of two people in a group of %d having the same birthday is %.2f %n",groupSize,probability );
            }
            else if ( choice == 2 ){
                System.out.print("Enter chart data: ");
                chartData = input.next();
                if ( isValidNumeric(chartData)){
                    displayChart(chartData);
                }
                else {
                    System.out.println("Invalid Chart Data!");
                }
            }
            else if ( choice == 3 ){
                System.out.print( "Enter word to convert: " );
                word = input.next();
                newWord = convertWord(word);
                System.out.printf( "Original word: %s\tConverted word: %s%n",word, newWord );
            }
            else {
                System.out.println("Invalid choice");
            }
            choice = getChoice();
        }
        System.out.println("GOODBYE!");
        input.close();
    }
}

