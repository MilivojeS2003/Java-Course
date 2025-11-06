import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkTime {
    public static void main(String args[]){
        LocalDate date = LocalDate.now();
        Instant instant = Instant.now(); 
        System.out.println(date);
        System.out.println(instant);
    }
}
