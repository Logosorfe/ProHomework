package javaHomework.homework1;

public class Person {
    private String name;
    private String fullName;
    private byte age;

    public Person() {
    }

    public Person(String name, String fullName, byte age) {
        this.name = name;
        this.fullName = fullName;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void move() {
        System.out.println(fullName + " walks");
    }

    public void talk() {
        System.out.println(fullName + " talks");
    }
}
