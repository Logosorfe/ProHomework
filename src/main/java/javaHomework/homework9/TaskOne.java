package javaHomework.homework9;

import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            integerList.add(random.nextInt(100));
        }
        System.out.println("List of random elements - " + integerList);

        Set<Integer> integerSet = new TreeSet<>();
        Set<Integer> notUniqueIntegerSet = new HashSet<>();
        for (int element : integerList) {
            if (!integerSet.add(element)) {
                notUniqueIntegerSet.add(element);
            }
        }
        System.out.println("Sorted set of unique elements - " + integerSet);
        List<Integer> uniqueIntegerList = new ArrayList<>();
        for (int element : integerSet) {
            if (!notUniqueIntegerSet.contains(element)) {
                uniqueIntegerList.add(element);
            }
        }
        System.out.println("Only once seen unique elements - " + uniqueIntegerList);
    }
}
