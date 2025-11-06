import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;

public class WorkTime {
    public static void main(String args[]){
        LocalDate date = LocalDate.now();
        Instant instant = Instant.now(); 
        System.out.println(date);
        System.out.println(instant);

        HashMap<String,Double> map = new HashMap<>();
        map.put("apple", 0.9);
        map.put("orange", 1.9);
        map.put("banana", 1.0);

        System.out.println(map);
        System.out.println(map.get("orange"));
        System.out.println(map.get("micko")); // ako nema vraca null

        System.out.println(map.containsKey("micko")); // vracaju true i false
        System.out.println(map.containsKey("banana"));

        System.out.println(map.containsValue(1.0));

        Set<String> kljucevi = map.keySet();
        System.out.println(kljucevi); // [Marko, Ana, Petar]


        for(String key : map.keySet()){ // .keySet() daje sve kljuceve iz mape
            System.out.println(key + ": $" + map.get(key));
        }
    }
}
