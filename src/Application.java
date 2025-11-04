// Delovi auta - ne mogu postojati nezavisno
class Engine {
    private String type;
    private int horsepower;
    
    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }
    
    String getEngine(){
        return this.type + " " + this.horsepower;
    }

    public void start() {
        System.out.println("Motor " + type + " se pali (" + horsepower + " KS)");
    }
}

class Wheels {
    private int count;
    private String type;
    
    public Wheels(int count, String type) {
        this.count = count;
        this.type = type;
    }

    String getWheels(){
        return this.count + " " + this.type;
    }
    
    public void rotate() {
        System.out.println(count + " točkova (" + type + ") se okreću");
    }
}

// Auto POSEDUJE delove - Composition
class Car {
    private String brand;
    private Engine engine;      // Car HAS-A Engine (composition)
    private Wheels wheels;      // Car HAS-A Wheels (composition)
    
    public Car(String brand) {
        this.brand = brand;
        // Delovi se kreiraju ZAJEDNO sa autom
        this.engine = new Engine("V6", 250);
        this.wheels = new Wheels(4, "Letnje gume");
    }
    
    public Car(String brand, Engine engine, Wheels wheels){
        this.brand = brand;
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        System.out.println(brand + " vozi:");
        engine.start();
        wheels.rotate();
    }

    String displayCar(){
        return "Engine: " + this.engine.getEngine() + " Wheels: " + this.wheels.getWheels() + " Car Brand: " + this.brand; 
    }
    
    // Kada se Car objekat uništi, engine i wheels takođe nestaju!
}

public class Application {
    public static void main(String[] args) {
        Engine engine1 = new Engine("V10.1", 300);
        Wheels wheels1 = new Wheels(5, "Winter premium");
        Car car = new Car("BMW");
        Car mojeAuto = new Car("Passerati", engine1,wheels1);
        System.out.println(mojeAuto.displayCar());
        car.drive();
        
        // Engine i Wheels NE POSTOJE izvan Car objekta
        // Ne možeš pristupiti engine ili wheels direktno
    }
}