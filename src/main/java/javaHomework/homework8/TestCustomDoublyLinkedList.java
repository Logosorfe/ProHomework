package javaHomework.homework8;

import java.util.ListIterator;

public class TestCustomDoublyLinkedList {
    public static void main(String[] args) {
        CustomDoublyLinkedList cdll = new CustomDoublyLinkedList();
        cdll.add(5);
        cdll.addLast(6);
        cdll.addFirst(2);
        System.out.println(cdll);

        cdll.add(0, 3);
        System.out.println(cdll);
        cdll.add(3, 7);
        System.out.println(cdll);
        cdll.add(2, 8);
        System.out.println(cdll);
        System.out.println(cdll);

        System.out.println("Custom DoublyLinkedList size is " + cdll.size());
        cdll.remove(0);
        cdll.remove(4);
        cdll.remove(2);
        System.out.println(cdll);

        ListIterator<Node> iterator = cdll.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getData());
        }

        System.out.println("----------------------------");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous().getData());
        }
    }
}
