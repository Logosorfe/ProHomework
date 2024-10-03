package javaHomework.homework8;

import java.util.ListIterator;

public class CustomDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void add(int data) {
        Node newNode = new Node(null, data, null);
        size++;
        switch (head) {
            case null:
                head = newNode;
                tail = newNode;
                break;
            default:
                Node current = tail;
                current.setNext(newNode);
                newNode.setPrevious(current);
                tail = newNode;
        }
    }

    public void addLast(int data) {
        add(data);
    }

    public void add(int index, int data) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        Node newNode = new Node(null, data, null);
        size++;
        switch (index) {
            case 0:
                switch (head) {
                    case null:
                        head = newNode;
                        tail = newNode;
                        break;
                    default:
                        newNode.setNext(head);
                        head.setPrevious(newNode);
                        head = newNode;
                }
                break;
            default:
                if (index < size / 2) {
                    Node current = head;
                    int count = 0;
                    while (count < index - 1) {
                        current = current.getNext();
                        count++;
                    }
                    newNode.setNext(current.getNext());
                    newNode.setPrevious(current);
                    current.getNext().setPrevious(newNode);
                    current.setNext(newNode);
                } else {
                    Node current = tail;
                    int count = size - 1;
                    while (count > index + 1) {
                        current = current.getPrevious();
                        count--;
                    }
                    newNode.setNext(current);
                    newNode.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(newNode);
                    current.setPrevious(newNode);
                }
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) {
            Node temp = head.getNext();
            temp.setPrevious(null);
            head.setNext(null);
            head = temp;
/** При втором варианте остаётся у бывшего head ссылка на текущий head, не знаю сработает ли
garbage collector при втором варианте, поэтому оставил вариант выше */
//            head.getNext().setPrevious(null);
//            head = head.getNext();
            size--;
            return;
        }
        if (index == size - 1) {
            Node temp = tail.getPrevious();
            tail.setPrevious(null);
            temp.setNext(null);
            tail = temp;
            size--;
            return;
        }
        if (index < size / 2) {
            Node current = head;
            int count = 0;
            while (count < index - 1) {
                current = current.getNext();
                count++;
            }
            Node temp = current.getNext();
            current.setNext(temp.getNext());
            temp.getNext().setPrevious(current);
            temp.setNext(null);
            temp.setPrevious(null);
            size--;
        } else {
            Node current = tail;
            int count = size - 1;
            while (count > index + 1) {
                current = current.getPrevious();
                count--;
            }
            Node temp = current.getPrevious();
            current.setPrevious(temp.getPrevious());
            temp.getPrevious().setNext(current);
            temp.setPrevious(null);
            temp.setNext(null);
            size--;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(null, data, null);
        size++;
        switch (head) {
            case null:
                head = newNode;
                tail = newNode;
                break;
            default:
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
        }
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public ListIterator<Node> iterator() {
        return new CustomListIterator();
    }

    @Override
    public String toString() {
        return print();
    }

    public class CustomListIterator implements ListIterator<Node> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public Node next() {
            int counter = 0;
            Node current = head;
            while (counter < cursor) {
                current = current.getNext();
                counter++;
            }
            cursor++;
            return current;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public Node previous() {
            int counter = size;
            Node current = tail;
            while (counter > cursor) {
                current = current.getPrevious();
                counter--;
            }
            cursor--;
            return current;
        }

        @Override
        public int nextIndex() {
            System.out.println("Method 'nextIndex' in ListIterator - work in progress");
            return 0;
        }

        @Override
        public int previousIndex() {
            System.out.println("Method 'previousIndex' in ListIterator - work in progress");
            return 0;
        }

        @Override
        public void remove() {
            System.out.println("Method 'remove' in ListIterator - work in progress");
        }

        @Override
        public void set(Node node) {
            System.out.println("Method 'set' in ListIterator - work in progress");
        }

        @Override
        public void add(Node node) {
            System.out.println("Method 'add' in ListIterator - work in progress");
        }
    }
}
