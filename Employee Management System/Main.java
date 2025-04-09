import java.util.*;

// Abstract class
abstract class Employee {
    String name;
    int id;
    double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    abstract void calculateSalary();
    abstract void displayInfo();
}

// Manager class
class Manager extends Employee {
    double bonus;

    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    void calculateSalary() {
        double total = baseSalary + bonus;
        System.out.println("Manager Salary: $" + total);
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Manager Info ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Bonus: $" + bonus);
    }
}

// Programmer class
class Programmer extends Employee {
    double overtimePay;

    public Programmer(String name, int id, double baseSalary, double overtimePay) {
        super(name, id, baseSalary);
        this.overtimePay = overtimePay;
    }

    @Override
    void calculateSalary() {
        double total = baseSalary + overtimePay;
        System.out.println("Programmer Salary: $" + total);
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Programmer Info ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Overtime Pay: $" + overtimePay);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Manager details
        System.out.print("Enter Manager Name: ");
        String mName = sc.nextLine();
        System.out.print("Enter Manager ID: ");
        int mId = sc.nextInt();
        System.out.print("Enter Base Salary for Manager: $");
        double mSalary = sc.nextDouble();
        System.out.print("Enter Bonus for Manager: $");
        double mBonus = sc.nextDouble();

        Manager mgr = new Manager(mName, mId, mSalary, mBonus);
        mgr.displayInfo();
        mgr.calculateSalary();

        sc.nextLine(); // Consume newline

        // Programmer details
        System.out.print("\nEnter Programmer Name: ");
        String pName = sc.nextLine();
        System.out.print("Enter Programmer ID: ");
        int pId = sc.nextInt();
        System.out.print("Enter Base Salary for Programmer: $");
        double pSalary = sc.nextDouble();
        System.out.print("Enter Overtime Pay for Programmer: $");
        double pOT = sc.nextDouble();

        Programmer prog = new Programmer(pName, pId, pSalary, pOT);
        prog.displayInfo();
        prog.calculateSalary();

        sc.close();
    }
}
