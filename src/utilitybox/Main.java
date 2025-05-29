package utilitybox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== UtilityBox ===");
            System.out.println("1. To-Do List");
            System.out.println("2. Password Generator");
            System.out.println("3. Passphrase Generator");
	        System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    TodoApp.run(scanner);
                    break;
                case "2":
                    PasswordGenerator.run(scanner);
                    break;
	        case "3":
		    PassphraseGenerator.run(scanner);
		    break;
                case "0":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

