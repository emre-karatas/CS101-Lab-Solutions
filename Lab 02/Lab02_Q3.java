/**
 * @(#)Lab02_Q3.java
 * Given three int values, first, middle and last, return true if one of middle or last is "close" 
 * (differing from first by at most 1), while the other is "far", differing from both 
 *  other values by 2 or more.   
 *
 * @author 
 * @version 1.00 2023/03/08
 */
import java.util.Scanner;
public class Lab02_Q3 {
        
    
    public static void main(String[] args) {
	       //assume neither is close
		  boolean special;
		  
		  //declare input variables
		  String inString;
		  char first, middle, last;
		  int strLen;

		  //input 3 values from user
		  System.out.print("Enter string: ");
		  Scanner input = new Scanner(System.in);
		  inString = input.nextLine();
		  
		  strLen = inString.length();

		  if ( strLen >= 3 ){
			special = false;
			first = inString.charAt( 0 );
			middle = inString.charAt( inString.length()/2 );
			last = inString.charAt( strLen-1 );

			input.close();
			//check all characters are between a - z
			if ( ( first >= 97 && first <= 122 ) && ( middle >= 97 && middle <= 122 ) && ( last >= 97 && last <= 122 ) ) {

				//check if b is close
				if ( Math.abs(middle-first) <= 1 ){
					if ( Math.abs(last-first) >= 2 && Math.abs(last-middle) >= 2 ){
						special = true;
					}
				}
				//check is c is close
				else if ( Math.abs(last-first) <= 1 ){
					if ( Math.abs(middle-first) >= 2 && Math.abs(middle-last) >=2 ){
						special = true;
					}
				}
				System.out.printf("first:%c middle:%c last:%c %n", first, middle, last);
				System.out.println("String is special: " + special );
			}
			else {
				System.out.println("Characters not lowercase letters...");
			}
		  }
		  else {
				System.out.println( "Length of string not sufficient" );
		  }		  
	}
}
