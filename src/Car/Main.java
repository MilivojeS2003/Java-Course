package Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String args[]){
        Person p1 = new Person();
        p1.name = "Ana"; // 
        p1.sayName(); 

        Test.sayHello();      // Poziv bez objekta za static metode ne treba nam objekat klase(instanca)
        System.out.println(Test.counter);

        System.out.println(Person.DAYS_IN_WEEK);

        int size = 10000000;

        List<Integer> arraylist = new ArrayList<>();
        long start = System.currentTimeMillis();

        for(int i=0;i<size;i++){
            arraylist.add(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("VRIJEME ZA ARRAYLIST JE: " + (end-start) + "ms");

        List<Integer> vector = new Vector<>();
        start = System.currentTimeMillis();

        for(int i=0;i<size;i++){
            vector.add(i);
        }

        end = System.currentTimeMillis();
        System.out.println("VRIJEME ZA VECTOR JE: " + (end-start) + "ms");


    }
}
