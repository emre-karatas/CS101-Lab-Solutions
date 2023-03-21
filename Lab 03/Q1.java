import java.util.Random;
import java.util.Scanner;

/**
 * Lab03_Q1
 */
public class Lab03_Q1 {

    public static void main(String[] args) {
        Random rand;

        String word1;
        String word2;
        String message;
        String encodedMessage;

        String decodedWord;
        int count;
        int pos1;
        int pos2;
        int randNum;
        int randPos;
        int splitPos;

        int choice;

        Scanner input = new Scanner( System.in );
        
        //display menu
        System.out.println("1) Encode Message");
        System.out.println("2) Decode Message");
        System.out.println("3) Quit");
        System.out.print("Enter choice: ");

        //initialize message to an empty string
        encodedMessage = "";

        //input choice from the user
        choice = input.nextInt();        
        
        while( choice != 3 )
        {
            //Encode word
            if ( choice == 1 ){
                input.nextLine();
                System.out.print("\nEnter word to encode: ");
                message = input.nextLine();        
                while ( message.length() < 2 ){
                    System.out.println("Invalid length word - try again");
                    System.out.print("Enter word to encode: ");
                    message = input.nextLine();
                }
                encodedMessage = message;

                rand = new Random();

                //add length random integers to the message
                int insert = encodedMessage.length();
                
                count = 0;
                while ( count < insert ){
                    randNum = rand.nextInt(10);
                    randPos = rand.nextInt(encodedMessage.length());
                    encodedMessage = encodedMessage.substring(0, randPos) + randNum + encodedMessage.substring(randPos);
                    count++;
                }
                splitPos = rand.nextInt(encodedMessage.length());
                //split into two strings separated by a space and save message
                encodedMessage =  encodedMessage.substring(splitPos) + " " + encodedMessage.substring(0, splitPos);
                System.out.println( "Encoded message: " + encodedMessage );
            }
            else if ( choice == 2 ){
                //if user has input word to encode
                if ( encodedMessage.length() > 0 ){ 
                    //get separate words
                    int index = encodedMessage.indexOf(" ");
                    if ( index != -1 ){
                        word2 = encodedMessage.substring(0, index );
                        word1 = encodedMessage.substring(index + 1);
        
                        pos1 = 0;
                        pos2 = 0;
                        decodedWord = "";
        
                        while( pos1 < word1.length() ){
                            //get next character from word1
                            if ( pos1 < word1.length() && Character.isLetter(word1.charAt(pos1)) ){
                                decodedWord += word1.charAt(pos1);
                            }
                            pos1++;
                        }
                        while( pos2 < word2.length() ){
                            //get next character from word2
                            if ( pos2 < word2.length() && Character.isLetter(word2.charAt(pos2))){
                                decodedWord += word2.charAt(pos2);    
                            }
                            pos2++;
                        }
                        System.out.println("The decoded message is: " + decodedWord );
                    }
                }
                else {
                    System.out.println("No message to decode....");
                }
                
            }
            else {
                System.out.println("Invalid choice - try again....");
            }   
            System.out.println("1) Encode Message");
            System.out.println("2) Decode Message");
            System.out.println("3) Quit");
            System.out.print("Enter choice: ");
            //input choice from the user
            choice = input.nextInt();
        }
        System.out.println("Thank you, goodbye!");
        input.close();       
    }
}
