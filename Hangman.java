import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        

        String random = words[(int)(Math.random() * 64)];
        
        char[] missed = new char[6];
        char[] wordGuess = new char[random.length()];
        char[] word = random.toCharArray();
        boolean gameOn = true;
        int match = 0;
        int misses = 0;
        int missedIndex = 0;

        showGallows(misses);

        System.out.print("Word: "  );
        for (int i = 0; i < word.length; i++) {
            wordGuess[i] = '_';
            }
        
        System.out.print(wordGuess);
        System.out.println("");
        System.out.print("Misses: ");
        System.out.print(missed);
        System.out.println("");
        System.out.print("Guess: ");
        

        while(gameOn) {
        match = 0;
        char guess = scan.next().charAt(0);
        word = random.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if (guess == word[i]) {
                wordGuess[i] = guess;
                match = 1;
            } else if (wordGuess[i] != '_') {
                
            } else {
                wordGuess[i] = '_';
                
            }
        }
        int duplicate = 0;
        if (match == 0) {
            
            for (int i = 0; i < 6; i++) {
                if (guess == missed[i]) {
                    duplicate = 1;
                } else {
                     
                }
            }
            if (duplicate != 1) {
                missed[missedIndex] = guess;
                    missedIndex++;
                    misses++;
                    
            } else {
                System.out.println("Letter already guessed");
            }
        } else {

        }
        showGallows(misses);
        if (misses == 6) {
            System.out.println("You lose.");
            System.out.println("The word was " + random);
            gameOn = false;
            break;
        } else {

        }
        System.out.print("Word: "  );
        System.out.print(wordGuess);
        System.out.println("");
        System.out.print("Misses: ");
        System.out.print(missed);
        System.out.println("");
        if (Arrays.equals(word, wordGuess)) {
            System.out.println("You win!");
            gameOn = false;
            break;
        } else {
            
        }
        System.out.print("Guess: ");

        

    }
        


        


        scan.close();


    }
    

    public static void showGallows(int misses) {
        for (int i = 0; i < 7; i++) {
            if (i == misses) {
                System.out.println(gallows[i]);
            } else {
                
            }
        }
    }

}





