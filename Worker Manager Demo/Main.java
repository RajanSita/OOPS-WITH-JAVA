// Base class
class Worker {
    int code;
    String name;
    float salary;

    // Constructor
    Worker(int code, String name, float salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }
}

// Derived class
class Manager extends Worker {
    float TA;       // Travelling Allowance
    float grossSal; // Gross Salary

    // Constructor
    Manager(int code, String name, float salary) {
        super(code, name, salary);
        this.TA = 0.10f * salary;
        this.grossSal = this.TA + salary;
    }

    // Method to display details
    void display() {
        System.out.println("Code       : " + code);
        System.out.println("Name       : " + name);
        System.out.println("Salary     : " + salary);
        System.out.println("TA (10%)   : " + TA);
        System.out.println("Gross Sal  : " + grossSal);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager(101, "Amit", 50000f);
        m.display();
    }
}
