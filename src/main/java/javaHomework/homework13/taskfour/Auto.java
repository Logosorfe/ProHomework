package javaHomework.homework13.taskfour;

import java.util.Objects;

public class Auto {
    private String number;
    private String colour;
    private final String brand;
    private int mileage;
    private float price;

    public Auto(String number, String colour, String brand, int mileage, float price) {
        this.number = number;
        this.colour = colour;
        this.brand = brand;
        this.mileage = mileage;
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "number='" + number + '\'' +
                ", colour='" + colour + '\'' +
                ", brand='" + brand + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
