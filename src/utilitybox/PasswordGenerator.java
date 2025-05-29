package utilitybox;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    public static void run(Scanner scanner) {
        System.out.print("Password length: ");
        try {
            int length = Integer.parseInt(scanner.nextLine());

            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int idx = random.nextInt(chars.length());
                password.append(chars.charAt(idx));
            }

            System.out.println("Generated: " + password.toString());
        } catch (NumberFormatException e) {
            System.out.println("Invalid length.");
        }
    }
}

