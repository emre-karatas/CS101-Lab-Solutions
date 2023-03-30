import java.util.Scanner;

public class Lab05_Q2 {

        public static char convertChar( char ch, String KEY ){
            for (int i = 0; i < KEY.length(); i +=2 ){
                if(ch == KEY.charAt(i)) {
                    return KEY.charAt(i+1);
                }
            }
            return ch;
        }
        public static String convertText(String text, String KEY ) {
            String converted = "";
            for (int i = 0; i < text.length(); i++ ){
                converted += convertChar( text.charAt(i), KEY );
            }
            return converted;
        }
        public static int countNumbers( String text ) {
            int count = 0;
            for ( int i = 0; i < text.length(); i++ ) {
                char ch = text.charAt( i );
                if ( Character.isDigit( ch ) ) {
                    count += 1;
                }
            }
            return count;
        }

        
    public static void main(String[] args){
        final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";
        String phrase;
        String convertedPhrase;
        Scanner input = new Scanner( System.in );

        System.out.print( "Enter a phrase for conversion: ");
        phrase = input.nextLine();
        convertedPhrase = convertText( phrase, KEY );

        if ( phrase.length() == 0) {
            System.out.println("No phrase entered.");
        }
        else {
            System.out.print("Text you entered: '" + phrase + "'");
            System.out.print("After conversion: '" + convertedPhrase + "'");
        
            if ( countNumbers( convertedPhrase) == 0 ) {
                System.out.print("!! Attention !! There are numbers in this text");
            }
            
            if ( convertedPhrase.equals( phrase )) {
                }System.out.print("No conversion happened.");
            }
            input.close();
        }

        
    }        
    
            

