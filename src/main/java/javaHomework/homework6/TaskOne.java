package javaHomework.homework6;

import java.util.ArrayList;
import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(9);
        integers.add(3);
        integers.add(8);
        integers.add(5);
        integers.add(2);
        integers.add(7);
        integers.add(1);
        integers.add(6);
        integers.add(4);

        TaskOne taskOne = new TaskOne();
        System.out.println("List with multiplied integers - "
                + taskOne.doubleIntegers(integers));
        System.out.println("Original list - " + integers);
    }

    public List<Integer> doubleIntegers(List<Integer> integers) {
        ArrayList<Integer> tempIntegers = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            tempIntegers.add(integers.get(i)*2);
        }
        return tempIntegers;
    }

}
