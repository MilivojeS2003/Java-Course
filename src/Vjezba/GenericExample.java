package Vjezba;

class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}

public class GenericExample {
    public static void main(String[] args) {

        // Primjer 1: Box sa Integer tipom
        Box<Integer> intBox = new Box<>(123);
        System.out.println("Integer vrijednost: " + intBox.get());

        // Primjer 2: Box sa String tipom
        Box<String> strBox = new Box<>("Hello Generics!");
        System.out.println("String vrijednost: " + strBox.get());

        // Promjena vrijednosti
        strBox.set("Novi String");
        System.out.println("Promijenjena vrijednost: " + strBox.get());
    }
}

