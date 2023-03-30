import java.util.Scanner;

public class Lab05_Q1 {
    public static int persistence( int num ) {
        /**  Assumes num is a positive int
        Finds and returns its multiplicative persistence, 
        which is the number of times we must multiply the digits in num 
        until we reach a single digit.
        */
        int product;
        int count;
        int lastDigit;
        
        product = num;
        count = 0;
        while ( product >= 10 ) {
            num = product;
            product = 1;
            count += 1;
            while ( num > 0 ){
                lastDigit = num % 10;
                product *=  lastDigit;
                num = num / 10;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n;
        int mult_persistence;
      
        Scanner input = new Scanner( System.in );
        do {
            System.out.print("Enter a positive integer: ");
            while( !input.hasNextInt() ){
                input.next();
                System.out.print("Enter a positive integer: ");
            }
            n = input.nextInt();
        } while ( n <= 0 );
        mult_persistence = persistence(n);
        System.out.printf("multiplicative persistence of %d is %d", n, mult_persistence );
        
        input.close();
    }
}




