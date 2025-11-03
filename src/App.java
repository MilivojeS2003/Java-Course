import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int x = 21;

        char dolar = '$';

        String myname = "Micko";
        System.out.println(dolar + " " + x + " " + myname);

        //Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter your name:");
        // String name = scanner.nextLine();
                
        // System.out.println("Enter your age:");
        // int age = scanner.nextInt();


        // System.out.println("Hello " + name + " and you are " + age + " old");
        // scanner.close();

        boolean isStudent = true;
        boolean isSenior = true;
        double price = 14.90;

        if(isStudent){
            if(isSenior){
                System.out.println("You get a student discount of 30%");
                price = price * 0.7;   
            }
            else{
                System.out.println("You get a student discount of 10%");
                price = price * 0.9;
            }
        }else{
            System.out.println("Dont have a discount");
            price *= 1;
        }
            System.out.printf("The price of ticket is: $%.2f \n", price);

            String nameNew = "Bro Code";
            int length = nameNew.length();
            char letter = nameNew.charAt(0);
            int index = nameNew.lastIndexOf("o");
            
            String name = nameNew.replace("o","a");

            System.out.println(letter);
            System.out.println(name);

        if(name.equals(nameNew)){
            System.out.println("Name equal new name");
        }else{
            System.out.println("Name not equal new name");

        }
    }
}
