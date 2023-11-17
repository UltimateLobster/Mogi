import java.util.Scanner;

//Represents a guessing game object. Initialize a game object and call the start method to begin playing.
public class Game {

    private int numbersOfGuess = 0;
    private Word choiceWord;
    private String banksOfAlphabet = "abcdefghijklmnopqrstuvwxyz";
    
    // constructor
    public Game() {
        this.choiceWord = new Word(Vocabulary.getRandomWord());
    }
    //Check the syntax of the character
    private Boolean checkCSyntaxCharacter(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }
    //Check the character is in alphabet
    private Boolean checkCharacterInAplhabet(char Ccharacter) {
        return banksOfAlphabet.contains(new StringBuilder(1).append(Ccharacter));
    }
  
    public String guessCharacter(String gameWord, char character) {
        while (checkCSyntaxCharacter(character) == false || checkCharacterInAplhabet(character) == false) {
            Scanner scan = new Scanner(System.in);
            System.out.println("The character need to contain only new charactert,enter new character: ");
            character = scan.next().charAt(0);
            scan.close();
        }
        setBanksOfAlphabet(banksOfAlphabet, character);
        gameWord = setGameWord(gameWord, character);
        this.numbersOfGuess += 1;
        return gameWord;
    }
    //Update the alphabet
    private void setBanksOfAlphabet(String setBanksOfAlphabet, char character) {
        this.banksOfAlphabet = banksOfAlphabet.replace(new StringBuilder(1).append(character), "");
    }
    //Return the length of guess word 
    public int choiceWordLength() {
        return choiceWord.getWord().length();
    }
    //Update the game word
    public String setGameWord(String gameWord, char character) {
        for (int i = 0; i < choiceWordLength(); i++) {
            if (choiceWord.getWord().charAt(i) == character) 
                gameWord = gameWord.substring(0, i) + character + gameWord.substring(i + 1);
        }
        return gameWord;
    }
 // Start starts the game loop
    public void start() {

        String gameWord = new String(new char[choiceWordLength()]).replace("\0", "_");
        System.out.println(gameWord);
        char character;
        Scanner scan = new Scanner(System.in);
        while (gameWord.contains("_")) {
            
            System.out.print("Enter character: ");
            character = scan.next().charAt(0);
            gameWord = guessCharacter(gameWord,character);
            System.out.println(gameWord);
            
        }
        scan.close();
        System.out.println("Game is done,your number of guess are: " + numbersOfGuess);

    }

}
