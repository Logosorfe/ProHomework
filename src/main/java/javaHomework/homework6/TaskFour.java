package javaHomework.homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskFour {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("to", "be", "or", "not", "to", "be");

        System.out.println("Unique string's list - " + uniqueStrings(stringList));
        System.out.println("Original list - " + stringList);
    }
    public static List<String>uniqueStrings(List<String> stringList){
        List<String> tempStrings = new ArrayList<>();
        for (String element : stringList){
            if (!tempStrings.contains(element)){
                tempStrings.add(element);
            }
        }
        return tempStrings;
    }
}
