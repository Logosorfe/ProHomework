package javaHomework.homework1;

public class Phone {
    private int number;
    private String model;
    private short weight;

    public Phone() {
    }

    public Phone(int number, String model, short weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public short getWeight() {
        return weight;
    }

    public void receiveCall(String name) {
        System.out.println(name + " calls");
    }
}
