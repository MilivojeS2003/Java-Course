import java.util.Scanner;
import java.util.Arrays;

public class Nizovi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // // String[] foods = new String[3];
        // int size;
        // String[] foods;

        // System.out.print("Enter size of array: ");
        // size = scanner.nextInt();

        // foods = new String[size];
        
        // scanner.nextLine(); // da ne bi preskocio prvi unos!!!
        // for(int i=0; i<size; i++){
        //     System.out.print("Enter your food: ");
        //     foods[i] = scanner.nextLine();
        // }
        
        // for(String food : foods){
        //     System.out.print(food + " ");
        // }

        add(1,2,3,4);

        String[] fruits = {"apple","banana","peach"};
        String[] meats = {"pork", "beef", "fish"};
        String[][] grocories = {fruits, meats}; // String[][] -> niz u niz!

        for(String[] foods : grocories){
            for(String food : foods){
                System.out.print(food + " ");
            }
            System.out.println("");
        }
        scanner.close();
    }

    static void add(int ... numbers){
        //System.out.println(numbers); // Vraca adresu!
        for(int number : numbers){
            System.out.println(number);
        }
    }
}
