import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Method using throws keyword
    public static String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        return reader.readLine();
    }

    public static void main(String[] args) {
        try {
            String name = getUserInput();
            System.out.println("Hello, " + name + "! Welcome to the ThrowsKeywordDemo.");
        } catch (IOException e) {
            System.out.println("An input error occurred: " + e.getMessage());
        }
    }
}
