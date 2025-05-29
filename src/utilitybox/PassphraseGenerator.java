package utilitybox;

import java.io.*;
import java.util.*;

public class PassphraseGenerator {
    private static final String WORDLIST_PATH = "data/eff_large_wordlist.txt";
    private static final int DEFAULT_WORD_COUNT = 6;
    private static final Random random = new Random();

    private static Map<String, String> wordMap;

    public static void run(Scanner scanner) {
        ensureWordlistLoaded();

        System.out.print("How many words? (default 6): ");
        String input = scanner.nextLine();
        int wordCount = DEFAULT_WORD_COUNT;
        try {
            if (!input.isEmpty()) {
                wordCount = Integer.parseInt(input);
            }
        } catch (NumberFormatException ignored) {
            System.out.println("Using default: 6 words.");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            String roll = rollDice();
            String word = wordMap.getOrDefault(roll, "?????");
            result.append(word);
            if (i < wordCount - 1) result.append(" ");
        }

        System.out.println("Generated passphrase:");
        System.out.println(result);
    }

    private static void ensureWordlistLoaded() {
        if (wordMap != null) return;
        wordMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(WORDLIST_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+", 2);
                if (parts.length == 2) {
                    wordMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load wordlist: " + e.getMessage());
            System.exit(1);
        }
    }

    private static String rollDice() {
        StringBuilder roll = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            roll.append(1 + random.nextInt(6));
        }
        return roll.toString();
    }
}

