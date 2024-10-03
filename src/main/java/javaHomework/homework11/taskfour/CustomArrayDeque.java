package javaHomework.homework11.taskfour;

import java.util.Iterator;

public class CustomArrayDeque implements MyDeque {

    private Integer[] elements;
    /**
     * Убрал final, так как она препятствует росту массива
     */

    private int head;

    private int tail;

    public CustomArrayDeque(int capacity) {/** При такой записи (capacity < 1) можно создать массив с одним
     элементом. Мало того что само дальнейшее утверждение "Capacity must be more than 1"
     не будет работать. Так ещё и выдаст ошибку ArrayIndexOutOfBoundsException при
     использовании метода addToHead, созданного тут. Поставил изначальный размер в 16 элементов.*/
        if (capacity < 16) throw new IllegalArgumentException("Capacity must be more than 15");
        this.elements = new Integer[capacity];
        this.head = (capacity) / 2;
        this.tail = head;
    }

    @Override
    public void addToHead(Integer element) {/** Исправил код, так как он не учитывал
     возможности того, что на месте изначального head может быть null */
        if (size() >= elements.length / 2)
            resizeArray();
        if (elements[head] == null) {
            elements[head] = element;
            return;
        }
        head = head - 1;
        elements[head] = element;
    }

    @Override
    public void addToTail(Integer element) {/** Тоже исправил код, так как он не учитывал
     возможности того, что на месте изначального head может быть null и поменял местами
     два выражения в коде else */
        if (size() >= elements.length / 2)
            resizeArray();
        if (elements[tail] == null) {
            elements[tail] = element;
            return;
        }
        tail = tail + 1;
        elements[tail] = element;
    }

    @Override
    public Integer pollHead() { /** В настоящем ArrayDeque все элементы станут ссылаться на
     null, что здесь изначально отсутствует. Исправил */
        Integer element = elements[head];
        if (head == tail) {
            elements[head] = null;
            return element;
        }
        elements[head] = null;
        head++;
        return element;
    }

    @Override
    public Integer pollTail() { /** Тоже исправил, при этом ещё местами был напутан код */
        Integer element = elements[tail];
        if (tail == head) {
            elements[tail] = null;
            return element;
        }
        elements[tail] = null;
        tail--;
        return element;
    }

    @Override
    public Integer peekHead() {
        return elements[head];
    }

    @Override
    public Integer peekTail() {
        return elements[tail];
    }

    @Override
    public boolean isEmpty() {
        return elements[head] == null;
    }

    @Override
    public int size() {
        return tail - head + 1;
    }

    private void resizeArray() {/** Написал метод самоувелечения очереди */
        Integer[] tempArray = new Integer[(int) ((double) 3 / 2 * elements.length)];
        int i = head + size() / 2;
        int j = tempArray.length / 2;
        while (i <= tail) {
            tempArray[j] = elements[i];
            j++;
            i++;
        }
        int k = head + size() / 2;
        int l = tempArray.length / 2;
        while (k >= head) {
            tempArray[l] = elements[k];
            l--;
            k--;
        }
        head = l + 1;
        tail = j - 1;
        elements = tempArray;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {
        int cursor = head;

        @Override
        public boolean hasNext() {
            return cursor <= tail;
        }

        @Override
        public Integer next() {
            int i = cursor;
            cursor++;
            return elements[i];

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i <= tail; i++) sb.append(elements[i] + ", ");
        return sb.toString();
    }
}
