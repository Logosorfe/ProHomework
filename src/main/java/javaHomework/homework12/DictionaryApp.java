package javaHomework.homework12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> dictionary = new HashMap<>();

        while (true) {
            System.out.println("Enter word in search for Russian translation");
            String englishWord = scanner.nextLine();
            if (!dictionary.containsKey(englishWord)) {
                System.out.println("Word does not has a translation\nEnter translation in Russian");
                dictionary.put(englishWord, scanner.nextLine());
            } else {
                System.out.println("Russian translation for '" + englishWord + "' is - " +
                        dictionary.get(englishWord));
            }
            System.out.println("Would you like to display whole dictionary?\nY/N?");
            if (scanner.nextLine().equalsIgnoreCase("Y")) break;
        }
        System.out.println(dictionary);
    }
}
