package zoo;

public class Animal {
    String name;
    String color;

    Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    void getAnimal() {
        System.out.println("Name: " + name + ", Color: " + color);
    }

    // protected inner class - dozvoljeno za inner klase
    protected class Heart {
        String color;
        int size;             // koristimo "size" malim slovom po konvenciji

        // glavni konstruktor
        Heart(String color, int size) {
            this.color = color;
            this.size = size;
        }

        // alternativni konstruktor
        Heart(String color) {
            this(color, 0);   // !!!! pozivamo gornji konstruktor
        }

        void getHeart() {
            System.out.println("Color: " + color + ", Size: " + size);
        }
    }

    // unutar Animal i podklasa
    protected class Leg {
        Double size;
        int number;

        Leg(Double size, int number) {
            this.size = size;
            this.number = number;
        }
        void getLeg() {
            System.out.println("Number: " + number + ", Size: " + size);
        }
    }
}
