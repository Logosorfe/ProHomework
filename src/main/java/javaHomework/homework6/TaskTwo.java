package javaHomework.homework6;

import java.util.ArrayList;

public class TaskTwo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("how");
        strings.add("are");
        strings.add("you");
        strings.add("today");

        TaskTwo taskTwo = new TaskTwo();
        System.out.println("Original list - " + strings);
        System.out.println("Size of each string - "
                + taskTwo.sizeOfEachString(strings));
    }
    public ArrayList<Integer>sizeOfEachString(ArrayList<String> strings){
        ArrayList<Integer>tempIntegers=new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            tempIntegers.add(strings.get(i).length());
        }
        return tempIntegers;
    }
}
