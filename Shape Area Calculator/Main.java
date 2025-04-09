import java.util.*;

// Shape interface
interface Shape {
    double getArea();
}

// Rectangle class
class Rectangle implements Shape {
    double length, width;

    Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

// Circle class
class Circle implements Shape {
    double radius;

    Circle(double r) {
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Triangle class
class Triangle implements Shape {
    double base, height;

    Triangle(double b, double h) {
        this.base = b;
        this.height = h;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Shape Area Calculator ===");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");
        System.out.print("Choose a shape (1-3): ");
        int choice = sc.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1:
                System.out.print("Enter length: ");
                double length = sc.nextDouble();
                System.out.print("Enter width: ");
                double width = sc.nextDouble();
                shape = new Rectangle(length, width);
                break;

            case 2:
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                shape = new Circle(radius);
                break;

            case 3:
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                shape = new Triangle(base, height);
                break;

            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        System.out.println("Area: " + shape.getArea());
        sc.close();
    }
}
