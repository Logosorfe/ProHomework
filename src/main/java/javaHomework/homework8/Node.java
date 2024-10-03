package javaHomework.homework8;

public class Node {

    private Node previous;
    private Integer data;
    private Node next;

    public Node(Node previous, Integer data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
