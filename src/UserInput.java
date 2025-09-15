// UserInput.java
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Please, enter number from " + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter number.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
