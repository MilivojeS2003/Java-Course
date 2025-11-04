public class Main {
    public static void main(String[] args){
        Student std1 = new Student("Micko", 22, 7.0, false);
        Student std2 = new Student("Milivoje", 21, 8.0);
        Person pr1 = new Person("Darko", 50);

        System.out.println(std1.name);
        System.out.println(std1.age);
        System.out.println(std1.gpa);
        System.out.println(std1.isEnrolled);
        std1.study();

        System.out.println(std2.name);
        System.out.println(std2.age);
        System.out.println(std2.gpa);
        System.out.println(std2.isEnrolled);
        std2.study();

        System.out.println("Total number of student: " + std1.totalStudents); // **

        Student[] students = {std1, std2,  new Student("Nikola",29,9.0)};

        for(Student student:students){
            student.study();
        }

        System.out.println("Total number of student: " + std1.totalStudents); // nije isti total kao u (**)
        std1.introduce();

        System.out.println("**************************");
        System.out.println(pr1.name);
        System.out.println(pr1.age);
        pr1.introduce();

        System.out.println("******** toString() **********");
        System.out.println(std1.toString());

        
        System.out.println("**************************");


        //  DINAMIC POLYMORFISAM!!!! -> Runtime Polymorphism
        Animal animal1 = new Dog();  
        Animal animal2 = new Cat();  // Tip Animal, objekat Cat
        
        animal1.makeSound();  // "Av av!" - JVM odlučuje u runtime-u
        animal2.makeSound();  // "Mjau!" - JVM odlučuje u runtime-u

        // JVM (Java Virtual Machine) odlučuje u vreme izvršavanja koja će metoda biti pozvana, 
        // na osnovu stvarnog objekta, ne tipa reference.


        Book book1 = new Book("Mickova", 290);
        Book book2 = new Book("Mickova1", 200);
        Book book3 = new Book("Mickova2", 210);
    
        System.out.println(book1.diplayInfo());

        Book[] books = {book1,book2,book3};

        Library library1 = new Library("P.B Podgorica", 1900, books);
        library1.displayInfo();
    }
}

// Osnovna klasa
class Animal {
    public void makeSound() {
        System.out.println("Životinja pravi zvuk");
    }
}

// Izvedene klase
class Dog extends Animal {
    private String name;
    private String sort;



    String getName(){
        return this.name;
    }
    String getSort(){
        return this.sort;
    }

    void setName(String name){
        this.name = name;
    }

    void setSort(String sort){
        this.sort = sort;
    }

    @Override
    public void makeSound() {
        System.out.println("Av av!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Mjau!");
    }
}


// Aggregations

class Book {
    String title;
    int pages;

    Book(String title, int pages){
        this.title = title;
        this.pages = pages;
    }

    String diplayInfo(){
        return this.title + " (" + this.pages + ") pages"; 
    }
}

class Library{
    String name;
    int year;
    Book[] books;

    Library(String name, int year, Book[] books){
        this.name = name;
        this.year = year;
        this.books = books;
    }

    void displayInfo(){
        System.out.println("The " + this.year + " " + this.name);
        System.out.println("Books available: ");
        for(Book b : books){
            System.out.println(b.title);
        }
    }
}