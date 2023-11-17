import java.util.Random;

//Vocabulary's only designation is to deliver a single random word from a pre defined array of words.
//It's not meant to be instantiated.
public class Vocabulary {
	
	// auto generated array of random words
    private static final String[] WORDS = { "sum" ,"yes"};

    public Vocabulary() {
    }

    public static String[] getWords() {
        return WORDS;
    }
    // returns a random word from the vocabulary.
    protected static String getRandomWord() {
        Random rnd = new Random();
        int index = rnd.nextInt(WORDS.length);
        return WORDS[index];
    }

}
