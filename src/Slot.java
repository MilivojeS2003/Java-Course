import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Slot {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int balance = 100;
        int bet;
        int payout;
        String[] row;

        System.out.println("Welcome to Java Slot");
        System.out.println("Symbols: [Lemon] [Grape] [Cherry] [Star] [Bell]");



        while(balance > 0){        
            System.out.println("Current balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();

            if(bet > balance){
                System.out.println("INSUFFICENT FUNDS");
                continue;
            }else if(bet <= 0){
                System.out.println("Bet must have greate than 0");
                continue;
            }else{
                balance -= bet;
            }

            //System.out.println(spinRow());
            row = spinRow();
            printRow(row);
            payout = getPayout(row,bet);

            if(payout == 0){
                System.out.println("YOU LOSE!");
            }else{
                System.out.println("YOU WINNN! Payout is: $" + payout);
                balance += payout;
            }
        }


        scanner.close();
    }

    static String[] spinRow(){
        String[] symbol = { "Lemon", "Grape", "Cherry", "Star", "Bell"};
        int size = 3;
        String[] row = new String[size];
        Random random = new Random();

        for(int i=0; i<size;i++){
            row[i] = symbol[random.nextInt(0,symbol.length)];
        }
        //System.out.println(row[0] + row[1] + row[2]);
        return row;
    }

    static int getPayout(String[] row, int bet){
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "Cherry" -> bet * 3;
                case "Grape" -> bet * 4;
                case "Lemon" -> bet * 5;
                case "Bell" -> bet * 10;
                case "Star" -> bet * 20;
                default -> 0;
            };
        }else{
            return 0;
        }
    }

    static void printRow(String[] row){
        for(int i=0; i<row.length; i++){
            System.out.print(row[i] + " | ");
        }
        System.out.println("");
    }
}
