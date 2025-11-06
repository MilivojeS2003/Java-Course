import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String args[]){

        String filePath = "text.txt";
        ArrayList<String> words = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
        while((line = reader.readLine()) != null){
            words.add(line);
        }
        } catch(FileNotFoundException e){
            System.out.println("Could not find file");
        } catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        System.out.println(word);

        // System.out.println(word.indexOf("z"));
        // System.out.println(word.indexOf("w"));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for(int i=0;i < word.length(); i++){
            wordState.add('_'); 
        }

        //System.out.println(wordState);
        //System.out.println(getHangmanArt(1));
        while(wrongGuesses < 6){
            System.out.print("WORD: ");
            for(char w : wordState){
                System.out.print(w + " ");
            }
            System.out.println("");

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            if(word.indexOf(guess) >= 0){
                System.out.println("Correct guess!");
                for(int i=0; i<word.length();i++){
                    if(word.charAt(i) == guess){
                        wordState.set(i,guess);
                    }
                }
                if(!wordState.contains('_')){
                    System.out.println("Correct!!! You WINN");
                    break;
                }
            }else{
                wrongGuesses++;
                System.out.println(getHangmanArt(wrongGuesses));
            }
        }

        if(wrongGuesses == 6){
            System.out.println("You are loss");
            System.out.println("The Word was " + word);
        }else{
            System.out.println("Correct!!! You WINN");
        }


        scanner.close();
    }

    public static String getHangmanArt(int promasaji) {
    String[] stages = {
        // 0 promasaja
        """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,
        // 1 promasaj
        """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,
        // 2 promasaja
        """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
        // 3 promasaja
        """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
        // 4 promasaja
        """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
        // 5 promasaja
        """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
        // 6 promasaja - GAME OVER
        """
          +---+
          |   |
          O   |
         /|\\ |
         / \\ |
              |
        =========
        """
    };
    
    if (promasaji < 0 || promasaji >= stages.length) {
        return stages[0];
    }
    
    return stages[promasaji];
}
}
