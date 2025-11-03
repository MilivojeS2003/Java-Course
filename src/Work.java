import java.util.Scanner;

public class Work {
    public static void main(String[] args){
        // String email = "milivoje@gmail.com";
        // String username = email.substring(0, email.lastIndexOf("@"));
        // String domen = email.substring(email.lastIndexOf("@")+1, email.lastIndexOf("."));
        // System.out.println(username);
        // System.out.println(domen);
        
        Scanner scanner = new Scanner(System.in);

        double weight;
        double newWeight;
        int choice;

        System.out.println("Wighth conversion program");
        System.out.println("1. Conver lbs in kg");
        System.out.println("2. Conver kg in lbs");

        System.out.println("Chose an option:");
        choice = scanner.nextInt();
        
        if(choice == 1){
            System.out.println("Enter weight in lbs:");
            weight = scanner.nextDouble();
            newWeight = weight * 0.453592;
            System.out.printf("The new wwight in kg: %.2f \n" ,newWeight);

        }else if(choice == 2){
            System.out.println("Enter weight in kg:");
            weight = scanner.nextDouble();
            newWeight = weight * 2.20462;
            System.out.printf("The new wwight in lbs: %.2f \n" ,newWeight);

        }else{
            System.out.printf("Invalid choice!!!");

        }

        // variable = (condition) ? isTrue : isFalse;

        int score = 67;

        String passOrfail = (score > 60) ? "Pass" : "Fail";

        System.out.println(passOrfail);


        scanner.close();

        Scanner scannerNew = new Scanner(System.in);

        String username;
        System.out.println("Enter you username: ");
        username = scannerNew.nextLine();

        if(username.length() < 4 || username.length() > 12){
            System.out.println("Username must be between 4-12 characters");
        }else{
            System.out.println("Welcome " + username);

        }

        scannerNew.close();



    }
}
