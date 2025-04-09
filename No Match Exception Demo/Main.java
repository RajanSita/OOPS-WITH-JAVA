import java.util.*;

// User-defined exception
class NoMatchException extends Exception {
    public NoMatchException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        try {
            checkString(input);
            System.out.println("You entered the correct string: ABC");
        } catch (NoMatchException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        sc.close();
    }

    public static void checkString(String str) throws NoMatchException {
        if (!str.equals("ABC")) {
            throw new NoMatchException("Input does not match 'ABC'");
        }
    }
}
