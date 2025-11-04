public class Student extends Person {
    double gpa;
    boolean isEnrolled;
    static int totalStudents ; // static promjneljiva je ona koja pripada KLASI A NE PROMLJIVOJ

    Student(String name,int age, double gpa){
        // this.name = name;
        // this.age = age;
        super(name,age);
        this.gpa = gpa;
        this.isEnrolled = false;
        this.totalStudents ++;
    }
    
    Student(String name, int age, double gpa, boolean isEnrolled){
        // this.name = name;
        // this.age = age;
        super(name,age); // Poziva se kontruktor roditeljske klase
        this.gpa = gpa;
        this.isEnrolled = isEnrolled;
        this.totalStudents ++;
    }

    public void study(){
        System.out.println("Student: " + this.name + " is studing!!!");
    }

    static void showStudent(){
        System.out.println("You have " + totalStudents + " total studnt"); // U staticnu metodu mogu se koristiti samo staticke promjenljive
                                                                          // Ako nismo porslijetili objekat klase preko argumenata
    }

    @Override
    void introduce(){
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old. I'm student!");
    }

    @Override
    public String toString(){
        return this.name + " " + this.age + " " + this.gpa + " " + this.isEnrolled;
    }

}
