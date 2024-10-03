package javaHomework.homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskThree {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(3, 8, 4, 1, 9, 5, 2, 7, 6);

        System.out.println("List with odd integers - " + oddIntegers(integerList));
        System.out.println("Original list - " + integerList);
    }

    public static List<Integer> oddIntegers(List<Integer> integerList) {
        List<Integer> tempIntegers = new ArrayList<>();
        for (Integer element : integerList) {
            if (element % 2 != 0)
                tempIntegers.add(element);
        }
        return tempIntegers;
    }
}
