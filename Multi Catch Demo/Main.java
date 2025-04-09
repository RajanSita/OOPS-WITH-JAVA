
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input values
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // Division (can cause ArithmeticException)
            int result = a / b;
            System.out.println("Result of division: " + result);

            // Array access (can cause ArrayIndexOutOfBoundsException)
            int[] arr = new int[3];
            System.out.print("Enter index to access (0-2): ");
            int index = sc.nextInt();
            System.out.println("Array value at index " + index + ": " + arr[index]);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }

        sc.close();
    }
}
