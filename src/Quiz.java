import java.util.Scanner;
import java.util.Arrays;

public class Quiz {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int odgovor;
        int score = 0;
        String[] questions = {
            "1. Koja planeta je najbliža Suncu?",
            "2. Ko je autor knjige 'Na Drini ćuprija'?",
            "3. Koja je hemijska oznaka za vodu?",
            "4. Koja država ima najviše stanovnika na svetu?",
            "5. Koji je glavni grad Kanade?"
        };

        String[][] answers = {
            {"A) Merkur", "B) Venera", "C) Zemlja", "D) Mars"},
            {"A) Ivo Andrić", "B) Mesa Selimović", "C) Dobrica Ćosić", "D) Branko Ćopić"},
            {"A) H2O", "B) CO2", "C) NaCl", "D) O2"},
            {"A) Indija", "B) Kina", "C) SAD", "D) Rusija"},
            {"A) Toronto", "B) Montreal", "C) Ottawa", "D) Vancouver"}
        };

        int[] correctAnswer = {1,1,1,2,3};

        for(int i=0; i<questions.length; i++){
            System.out.println(questions[i]);

            for(int j=0; j < answers[i].length; j++){
                
                System.out.println(answers[i][j]);
            
            }
              System.out.print("Enter correct answer (1-4):");
                odgovor = scanner.nextInt();

                if(correctAnswer[i] == odgovor){
                    System.out.println("CORECT!!!");
                    score++;
                }else{
                    System.out.println("WRONG!!!");
                }
        }
                System.out.println("*********************");
        

        System.out.println("Your score:" + score);

        scanner.close();

    }
}

