
import java.util.Scanner;

public class Lab01_Q2 {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	    	
        Scanner input;
        String inDate;
        String day;
        String month;
        String year;
        String date;
        String time;
        String hours;
        String minutes;
        	   
        int posSlash;
        int posSecondDash;
        int posComma;
        int posDash;
        int newHours;
        
        input = new Scanner( System.in );
        
        System.out.print("Enter date and time: ");
        inDate = input.nextLine();
        
        //find the delimiters
        posSlash = inDate.indexOf("/");
        time = inDate.substring(0,posSlash);
        hours = time.substring(0,2);
        minutes = time.substring(3);

        posDash = inDate.indexOf("-");
        posSecondDash = inDate.indexOf("-", posDash+1);
        posComma = inDate.indexOf(",");

        day = inDate.substring(posSlash+1,posDash);
        month = inDate.substring(posDash+1,posSecondDash);
        date = inDate.substring(posSecondDash + 1,posComma);
        year = inDate.substring(posComma + 1 );
        
        System.out.printf("%s minutes past %s on %s %s %s (%s) %n",minutes, hours, date, month, year, day);
    }
}
