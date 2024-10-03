package javaHomework.homework7;

import java.util.Iterator;

public class TaskTwo {
    public static void main(String[] args) {
        TaskTwo taskTwo = new TaskTwo(new int[]{2, 6, 4, 9, 3, 0, 5, 1, 8, 7});
        Iterator iterator = taskTwo.iterator();
        while(iterator.hasNext()){
            System.out.print(" " + iterator.next());
        }

    }

    private int[] integers;

    public TaskTwo(int[] integers) {
        this.integers = integers;
    }
    public Iterator iterator(){
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator {
        int cursor;

        @Override
        public Object next() {
            int i = cursor;
            cursor = i + 1;
            return integers[i];
        }

        @Override
        public boolean hasNext() {
            return cursor < integers.length;
        }
    }
}
