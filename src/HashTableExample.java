import java.util.*;

public class HashTableExample {
    public static void main(String[] args) {

        // 1️⃣ Kreiramo HashMap koja mapira ime studenta -> ocenu
        HashMap<String, Integer> students = new HashMap<>();

        // 2️⃣ Dodajemo elemente u mapu
        students.put("Ana", 95); // <key,value>
        students.put("Marko", 88);
        students.put("Ivana", 76);
        students.put("Petar", 90);
        students.put("Milica", 82);
        //students.put(95,"Miko");

        System.out.println("=== Početna mapa ===");
        printMap(students);

        // 3️⃣ Pristup vrednostima
        System.out.println("\nOcena Ane: " + students.get("Ana"));
        System.out.println("Ocena Ivane: " + students.get("Ivana"));
        IO.println("Pistupimo preko value: " + students.get(95)); // moze samo preko kljuca da se dodje do vrijednosti

        // 4️⃣ Provera postojanja ključa/vrednosti
        System.out.println("\nDa li postoji Marko? " + students.containsKey("Marko"));
        System.out.println("Da li postoji ocena 100? " + students.containsValue(100));

        // 5️⃣ Ažuriranje vrednosti
        students.put("Ivana", 80); // direktno menjamo vrednost
        System.out.println("\nPosle ažuriranja Ivane:");
        printMap(students);

        // 6️⃣ Uklanjanje elemenata
        students.remove("Petar"); //Samo preko Kljuva mozemo izbrisati mapu
        System.out.println("\nNakon brisanja Petra:");
        printMap(students);

        // 7️⃣ Korišćenje compute() za ažuriranje vrednosti pametno
        students.compute("Ana", (key, value) -> value + 5); // povećaj ocenu za 5
        students.computeIfAbsent("Nikola", k -> 70); // dodaj novog ako ne postoji
        System.out.println("\nPosle compute operacija:");
        printMap(students);

        // 8️⃣ Merge – spaja nove vrednosti sa postojećim
        students.merge("Marko", 5, Integer::sum); // dodaj 5 Marku
        students.merge("Nikola", 10, Integer::sum);
        System.out.println("\nPosle merge operacija:");
        printMap(students);

        // 9️⃣ replaceAll – npr. dodaj +2 svima
        students.replaceAll((key, value) -> value + 2);
        System.out.println("\nPosle replaceAll (+2 svima):");
        printMap(students);

        // 🔟 Iteracija kroz sve unose pomoću entrySet()
        System.out.println("\nIteracija preko entrySet():");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " -> Ocena: " + entry.getValue());
        }

        // 1️⃣1️⃣ Sortiranje po imenu (ključu)
        System.out.println("\nSortirano po imenu (ključu):");
        students.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // 1️⃣2️⃣ Sortiranje po oceni (vrednosti)
        System.out.println("\nSortirano po oceni (vrednosti):");
        students.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // 1️⃣3️⃣ Ispis svih ključeva i vrednosti posebno
        System.out.println("\nSvi ključevi: " + students.keySet());
        System.out.println("Sve vrednosti: " + students.values());
    }

    // Metoda za lep ispis
    private static void printMap(Map<String, Integer> map) {
        for (String key : map.keySet()) { // Na ovaj nacin prolazimo kroz mapu
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
