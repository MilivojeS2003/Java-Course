import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayVsArrayLIst {
    public static void main(String args[]){
        int size = 3;
        String[] friends = {"John","Milenka", "Viola", "Martini", "Jameson"};

        ArrayList<String> listOfFriends = new ArrayList<>(
                Arrays.asList("John","Milenka", "Viola", "Martini", "Jameson")
        ); // prednost u odnosu na obican Array je u tome sto ne mozamo da dajemo size
        
        System.out.println(listOfFriends); // daje el. niza 
        System.out.println(friends); // daje adresu samo
        for(String f : friends){
            System.out.print(f + " ");
        }
        System.out.println("");

        // !!! VAZNO !!! 
        // Tipovi nizova(array) mogu biti primitivni i referenti: String,int,boolean...
        // Kod ArrayList tip mora biti objekat, vazno je da su i referentni podaci objekti(String)!!!!

        System.out.println(friends[0]);
        // System.out.println(listOfFriends[0]); ---> Ovako ne moze kod ArrayList
        System.out.println(listOfFriends.get(0));

        // OVO NE MOZEMO SA ARRAY
        listOfFriends.add("Mickoo");
        System.out.println("OVO JE NOVA LIST: " + listOfFriends );
        listOfFriends.set(0,"Nikola");
        System.out.println("OVO JE NOVA LIST: " + listOfFriends );


        //REMOVE ELEMENT
        // .remove() nam daje dvije opcije!!!
        listOfFriends.remove(4);
        System.out.println("OVO JE NOVA LIST: " + listOfFriends );
        listOfFriends.remove("Nikola");
        System.out.println("OVO JE NOVA LIST: " + listOfFriends );


    } 
}
