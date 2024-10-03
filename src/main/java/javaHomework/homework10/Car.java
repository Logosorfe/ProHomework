package javaHomework.homework10;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String brand;

    private String color;

    private final String vinNumber;

    private String licensePlate;

    private boolean isOnLease;

    public Car(String brand, String color, String vinNumber, String licensePlate,
               boolean isOnLease) {
        this.brand = brand;
        this.color = color;
        this.vinNumber = vinNumber;
        this.licensePlate = licensePlate;
        this.isOnLease = isOnLease;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean getIsOnLease() {
        return isOnLease;
    }

    public void setIsOnLease(boolean onLease) {
        this.isOnLease = onLease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isOnLease == car.isOnLease && Objects.equals(color, car.color)
                && Objects.equals(licensePlate, car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, licensePlate, isOnLease);
    }

    @Override
    public int compareTo(Car o) {
        int result = this.vinNumber.compareTo(o.vinNumber);
        if (result == 0&&this!=o)
            System.out.println("\nDuplicate VIN number detected\nThis car is deleted - " +
                    this);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", onLease=" + isOnLease +
                '}';
    }
}
