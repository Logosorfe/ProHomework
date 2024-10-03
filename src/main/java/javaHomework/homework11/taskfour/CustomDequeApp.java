package javaHomework.homework11.taskfour;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class CustomDequeApp {

    public static void main(String[] args) {
        MyDeque custom = new CustomArrayDeque(16);
        Deque<Integer> original = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            original.addFirst(i);
            custom.addToHead(i);
        }
        for (int i = 0; i < 12; i++) {
            original.addLast(i);
            custom.addToTail(i);
        }
        for (int i = 0; i < 4; i++) {
            original.pollLast();
            custom.pollTail();
        }
        for (int i = 0; i < 2; i++) {
            original.pollFirst();
            custom.pollHead();
        }

        System.out.println(original);
        System.out.println(custom);

        Iterator<Integer> customIterator = custom.iterator();

        custom.addToTail(11);

        while (customIterator.hasNext()) {
            System.out.print(customIterator.next() + " ");
        }

        System.out.println();

        Iterator<Integer> originalIterator = original.iterator();

        original.addLast(11);  /** Получается, что после создания итератора, он не
         воспринимает вносимое мной изменение в очередь? */

        System.out.println(original);

        while (originalIterator.hasNext()) {
            System.out.print(originalIterator.next() + " ");
        }
    }
}
