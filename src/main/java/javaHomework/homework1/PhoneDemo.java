package javaHomework.homework1;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone phoneOne = new Phone();
        Phone phoneTwo = new Phone();
        Phone phoneThree = new Phone();

        System.out.println("First phone's number " + phoneOne.getNumber() +
                ", model " + phoneOne.getModel() + " & weight " + phoneOne.getWeight());
        System.out.println("Second phone's number " + phoneTwo.getNumber() +
                ", model " + phoneTwo.getModel() + " & weight " + phoneTwo.getWeight());
        System.out.println("Third phone's number " + phoneThree.getNumber() +
                ", model " + phoneThree.getModel() + " & weight " + phoneThree.getWeight());

        System.out.println();

        phoneOne.receiveCall("John");
        phoneTwo.receiveCall("Jane");
        phoneThree.receiveCall("Alex");

    }
}
