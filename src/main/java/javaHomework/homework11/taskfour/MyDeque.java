package javaHomework.homework11.taskfour;

import java.util.Iterator;

public interface MyDeque {

    void addToHead(Integer element);

    void addToTail(Integer element);

    Integer pollHead();

    Integer pollTail();

    Integer peekHead();

    Integer peekTail();

    boolean isEmpty();

    int size();

    Iterator<Integer> iterator();
}
