package javaHomework.homework7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TaskOne {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            integerList.add(i);
        }
        System.out.println("List with " + integerList.size() + " integers");

        TaskOne li = new TaskOne();
        System.out.println("For 'for-each' it took "
                + li.forEachEfficiency(integerList) + " ms");
        System.out.println("For classic 'for' with size it took "
                + li.classicForWithSIzeEfficiency(integerList) + " ms");
        System.out.println("For classic 'for' with variable it took "
                + li.classicForEfficiency(integerList) + " ms");
        System.out.println("For classic backward 'for' with variable it took "
                + li.classicBackwardForEfficiency(integerList) + " ms");
        System.out.println("For Iterator it took "
                + li.iteratorEfficiency(integerList) + " ms");
        System.out.println("For ListIterator it took "
                + li.listIteratorEfficiency(integerList) + " ms");
    }

    public long forEachEfficiency(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        for (int i : integerList) {
            int temp = i;
        }
        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public long classicForWithSIzeEfficiency(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < integerList.size(); i++) {
            int temp = integerList.get(i);
        }
        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public long classicForEfficiency(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        int quantity = integerList.size();
        for (int i = 0; i < quantity; i++) {
            int temp = integerList.get(i);
        }
        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public long classicBackwardForEfficiency(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        int quantity = integerList.size();
        for (int i = quantity - 1; i >= 0; i--) {
            int temp = integerList.get(i);
        }
        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public long iteratorEfficiency(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public long listIteratorEfficiency(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = integerList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }
}
