// Superclass
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Subclass Cat
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Main class to demonstrate run-time polymorphism
public class Main {
    public static void main(String[] args) {
        Animal a;

        a = new Dog();   // Animal reference but Dog object
        a.sound();       // Calls Dog's sound() method

        a = new Cat();   // Animal reference but Cat object
        a.sound();       // Calls Cat's sound() method
    }
}
