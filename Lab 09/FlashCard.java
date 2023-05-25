
public class FlashCard {
    private String question;
    private String answer;
    private int difficulty;

    public FlashCard( String question, String answer, int difficulty) {
        this.question = question;
        this.answer = answer;
        this.setDifficulty( difficulty );
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return this.answer;
    }
    private void setDifficulty( int difficulty) {
        if( difficulty >= 1 && difficulty <= 5 ) {
            this.difficulty = difficulty;
        }
        else {
            this.difficulty = 1;
        }
    }
    private String formatOutput( char outputType ) {
        String data = "";
        String result;
        if(outputType == 'Q')
            data = this.question;
        else {
            data = this.answer;
        }
        String repstring = ("*" + " ".repeat(4) + " ".repeat( data.length()) + " ".repeat(4)  +  "*" + "\n");
        result = ( "*".repeat( ( data.length() ) + 10) ) + "\n";
        result += repstring.repeat( 3 ); 
        result += "*" + (" ".repeat(4)) + data + (" ".repeat(4)) + "*" +"\n";
        result += repstring.repeat( 3 ); 
        result += "*".repeat(data.length() + 10) + "\n";
        return result;
    }
     
    public void showFlashCardQuestion(  ) {
        System.out.print( this.formatOutput('Q'));
    }
    public void showFlashCardAnswer(  ){
        System.out.print( this.formatOutput('A'));
    }
    
    public void reverseCard(){
        question = getQuestion();
        setQuestion( getAnswer());
        setAnswer( question );
    }
    
    public boolean equals( Object other ){
        if( other instanceof FlashCard ){
            FlashCard otherCard = (FlashCard)other;
            return question.toLowerCase().equals(otherCard.question.toLowerCase()) && (answer.toLowerCase().equals(otherCard.answer.toLowerCase()));
        }
        return false;
    }
    public String toString(){
        return question + '-' + answer + ':' + difficulty;
    }
}
    
    