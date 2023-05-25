
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FlashCardApp {
    public static void bubbleSort( ArrayList<FlashCard> cards ) {
        int j;
        boolean issorted;
        issorted = false;
        j = 0;
        while( j < cards.size() && !issorted ){
            for( int c = 0; c < cards.size() - j - 1; c++ ){
                if( cards.get(j+1).getQuestion().compareTo(cards.get(j).getQuestion()) < 0 ){
                    FlashCard temp = cards.get(j);
                    cards.set(j, cards.get(j+1));
                    cards.set(j+1, temp);
                }
            }
            j++;
        }
    }
    public static ArrayList<FlashCard> readCards( String filename ){

        String line;
        String[] data;
        
        //creates an empty list to store FlashCards
        ArrayList<FlashCard> cardList = new ArrayList<FlashCard>();

        File inFile = new File( filename );
        try {
            Scanner file = new Scanner( inFile );
            while( file.hasNext() ) {
                line = file.nextLine();
                data = line.split("\t");
                FlashCard  card = new FlashCard( data[0], data[1], Integer.parseInt(data[2]));
                cardList.add( card );
            }
            file.close();
        }catch( FileNotFoundException f ){
            System.out.println("file cannot be opened");
        }
        return cardList;
    }
    public static void main(String[] args) {
        int n;
        int score;
        ArrayList<FlashCard> words;
        ArrayList<FlashCard> flashCards;
        ArrayList<FlashCard> wrongAnswers;
        Scanner input = new Scanner( System.in );

        //read the words into a list
        words = readCards( "turkish_english_words.txt" );
        
        System.out.println("Enter the number of flash cards to generate: ");
        n = input.nextInt();
        input.nextLine();
        flashCards = new ArrayList<FlashCard>();

        //create a list of n random FlashCards
        while(flashCards.size() < n ){
            Random rand = new Random();
            int randomCardIndex = rand.nextInt( words.size() );
            FlashCard card = words.get( randomCardIndex );
            if( flashCards.indexOf( card )  == -1 ){
                flashCards.add( card );
            }
        }
        System.out.println( flashCards );
        //sort the list of FlashCards
        bubbleSort(flashCards);
        System.out.println( flashCards );
        
        String answer;
        score = 0;
        wrongAnswers = new ArrayList<FlashCard>();
        System.out.println("Let's play!"); 
        for(FlashCard card: flashCards) {
            card.showFlashCardQuestion();
            System.out.print("Enter your guess: ");
            answer = input.nextLine();
            if( answer.equalsIgnoreCase(card.getAnswer()) ){
                score += 1;
                System.out.println("Correct!");
            }
            else{
                System.out.println("Wrong answer");
                System.out.println("Let’s see the correct answer:");
                card.showFlashCardAnswer();
                wrongAnswers.add( card );
            }
        }
        System.out.printf( "Your score: %d / %d %n",score,n );

        if(wrongAnswers.size() > 0){
            System.out.println("Words you need to review: ");
            for(FlashCard card: wrongAnswers){
                System.out.println( "\t"+card );
            }
        }  
        input.close();
    }
}