import java.util.Scanner;

public class Lab04_Q3 {
    public static void main(String[] args) {
        String word;
        String newWord;
        int count;

        Scanner input = new Scanner( System.in );
        System.out.print( "Enter word to convert: " );
        word = input.next();

        while ( !word.equalsIgnoreCase("exit")  ){
            newWord = "";
            for( int i = 0; i < word.length(); i++){
                if ( !Character.isLetter(word.charAt(i)) ){
                    newWord += '*';
                }
                else { 
                    count = 1;
                    for ( int j = 0; j < word.length(); j++){
                    if( i != j && Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(word.charAt(j))){
                        count++;
                    }
                    
                    }
                    if( count != 1 ){
                        newWord += ")";
                    }
                    else {
                        newWord += "(";
                    }
                }
            }
            //word = newWord;
            System.out.printf( "Original word: %s\tConverted word: %s%n",word, newWord );
            System.out.print( "Enter word to convert: " );
            word = input.next();
        }
        input.close();
    }
}
