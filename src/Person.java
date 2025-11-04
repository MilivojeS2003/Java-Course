public class Person {
    String name;
    int age;


    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old. I'm person!!!");
    }
}
