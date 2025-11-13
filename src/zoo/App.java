package zoo;
import org.w3c.dom.Node;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Animal a = new Animal("Micko","Crn");
        Animal.Heart heart1 = a.new Heart("Crn",12);
        Animal.Leg leg1 = a.new Leg(4.0,4);

        heart1.getHeart();
        a.getAnimal();
        leg1.getLeg();

        Hashtable<String,String> table = new Hashtable<>(10);

        table.put("100", "SpongerBob");
        table.put("123", "Patrick");
        table.put("321", "Sandy");
        table.put("555", "Squidward");
        table.put("777", "Gary");

        for(String key : table.keySet()){
            IO.println(key.hashCode() + " -> " + key + " -> " +table.get(key));
        }


    }
}
