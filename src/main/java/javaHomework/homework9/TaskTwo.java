package javaHomework.homework9;

import java.util.*;

public class TaskTwo {
    public static void main(String[] args) {
        String smallString = "kdvnlks klgnerjkldbg sknkvf";
        String bigString = "dsknjrbl vlknearlkng srngkldkln srgklndl";

        Set<Character> variousSymbolsSet = new TreeSet<>();
        for (int i = 0; i < smallString.length(); i++) {
            variousSymbolsSet.add(smallString.charAt(i));
        }
        Set<Character> anotherVariousSymbolsSet = new TreeSet<>();
        for (int i = 0; i < bigString.length(); i++) {
            anotherVariousSymbolsSet.add(bigString.charAt(i));
        }
        List<Character> characterList = new ArrayList<>();
        for (char element : anotherVariousSymbolsSet) {
            if (variousSymbolsSet.contains(element)) {
                characterList.add(element);
            }
        }
        System.out.println("Unique symbols in both strings - " + characterList);
    }
}
