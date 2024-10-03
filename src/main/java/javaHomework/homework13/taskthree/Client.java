package javaHomework.homework13.taskthree;

import java.util.List;

public class Client {
    private final int id;
    private String name;
    private byte age;
    List<Phone> phoneList;

    public Client(int id, String name, byte age, List<Phone> phoneList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneList = phoneList;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneList=" + phoneList +
                '}';
    }
}
