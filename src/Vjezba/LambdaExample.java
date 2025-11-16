package Vjezba;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {

        // Lista brojeva
        List<Integer> brojevi = new ArrayList<>();
        brojevi.add(1);
        brojevi.add(2);
        brojevi.add(3);
        brojevi.add(4);
        brojevi.add(5);

        // Lambda izraz za ispis svakog elementa u listi
        System.out.println("Ispis brojeva lambda funkcijom:");
        brojevi.forEach(broj -> System.out.println("Broj: " + broj));

        // Lambda izraz za sabiranje
        Suma suma = (a, b) -> a + b;
        System.out.println("Suma 5 + 7 = " + suma.zbroji(5, 7));
    }
}

// Funkcionalni interfejs za lambda izraz
@FunctionalInterface
interface Suma {
    int zbroji(int a, int b);
}
