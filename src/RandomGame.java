import java.util.Random;
import java.util.Scanner;
public class RandomGame {
    public static void main(String[] args){
        
        // RANDOM GUESSING NUMBER

        // Random random = new Random();
        // Scanner scanner = new Scanner(System.in);

        // int guess;
        // int attempts=0;
        // int randomNumber = random.nextInt(1,11);

        // System.out.println("Guess a number between 1-10");

        // do{ 
        //     System.out.println("Enter a guess:");
        //     guess = scanner.nextInt();
        //     attempts++;

        //     if(guess < randomNumber){
        //         System.out.println("TOO LOW, try again");
        //     }else if(guess > randomNumber){
        //         System.out.println("TOO HIGH, try again");
        //     }
        // }while(guess != randomNumber || attempts > 10);
        
        System.out.println("Bravooo!!!");

        int N = 4;
        int M = 4;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print( j+i + " ");
            }
            System.out.print("\n");
        }
        
        int x = sumNumber(3,4);
        System.out.print("\n " + x);

        System.out.print("\n ADD:" + add(3,4,6));
    }

    static int sumNumber(int x, int y){
        return x+y;
    }

    // Overload methods
    static double add(double a, double b){
        return a+b;
    }

    static double add(double a, double b, double c){
        return a+b+c;
    }
}
