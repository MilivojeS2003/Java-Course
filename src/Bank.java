import java.util.Scanner;
import java.util.Arrays;

public class Bank {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        double balance = 0;
        boolean isRunning = true;
        int choice;

        String[] fruits = {"apple", "bannana", "peach", "orange"};

        System.out.println(fruits); // -> daje adresu!!!
        System.out.println(fruits[0]);

        Arrays.sort(fruits);
        for(String fruit : fruits){
            System.out.println(fruit);
        }

        while(isRunning){
        System.out.println("*********");
        System.out.println("BANKING PROGRAM");
        System.out.println("*********");
        System.out.println("1. Show balance");
        System.out.println("2. Deposit");
        System.out.println("Withdraw");
        System.out.println("Exit");
    
        System.out.print("Enter you choice (1-4):");
        choice = scanner.nextInt();
        

        switch(choice){
            case 1 -> showBalance(balance);
            case 2 -> balance += deposit();
            case 3 -> balance -= withdraw(balance);
            case 4 -> isRunning = false;
        }
    
    }

        scanner.close();
        
    }

    static void showBalance(double balance){
        System.out.printf("%.2f\n", balance);
    }

    static double deposit(){
        double amount;

        System.out.print("Enter an amount to be deposited:");
        amount = scanner.nextDouble();

        if (amount>0){
            return amount;
        }
        System.out.println("Amount cant be negative");
        return 0;
    }

    static double withdraw(double balance){
        double amount;
        System.out.print("Enter amount to be withdraw:");
        amount =  scanner.nextDouble();
        if(amount > balance || amount < 0){
            return 0;
        }else{
            return amount;
        }
    }

}
