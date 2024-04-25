package JavaHomework.homework11.taskfour;

public class CustomDequeApp {

    public static void main(String[] args) {
        MyDeque customArrayDeque = new CustomArrayDeque(16);
        customArrayDeque.addToHead(10);
        customArrayDeque.addToHead(15);
        customArrayDeque.addToTail(5);
        customArrayDeque.addToTail(8);

        System.out.println(customArrayDeque);

        System.out.println(customArrayDeque.pollHead());

        System.out.println(customArrayDeque.pollTail());

        System.out.println(customArrayDeque);
    }
}
