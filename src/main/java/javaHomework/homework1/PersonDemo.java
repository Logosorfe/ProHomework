package javaHomework.homework1;

public class PersonDemo {
    public static void main(String[] args) {
        Person personOne = new Person();
        personOne.setName("John");
        personOne.setFullName("Smith");
        personOne.setAge((byte) 12);

        Person personTwo = new Person("Jane", "Doe", (byte) 13);

        personOne.move();
        personOne.talk();
        System.out.println();
        personTwo.move();
        personTwo.talk();
    }
}
