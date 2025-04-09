// Interface A
interface A {
    void showA();
}

// Interface B
interface B {
    void showB();
}

// Class C implementing both A and B (Multiple Inheritance via Interfaces)
class C implements A, B {
    public void showA() {
        System.out.println("Method from Interface A");
    }

    public void showB() {
        System.out.println("Method from Interface B");
    }

    public void showC() {
        System.out.println("Method from Class C");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        C obj = new C();

        obj.showA();  // from Interface A
        obj.showB();  // from Interface B
        obj.showC();  // from its own class
    }
}
