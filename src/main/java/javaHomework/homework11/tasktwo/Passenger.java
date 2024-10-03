package javaHomework.homework11.tasktwo;

import java.util.Objects;

public class Passenger implements Comparable<Passenger>{
    private String name;
    private byte priorityClass;

    public Passenger(String name, byte priorityClass) {
        this.name = name;
        this.priorityClass = priorityClass;
    }

    public byte getPriorityClass() {
        return priorityClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return priorityClass == passenger.priorityClass && Objects.equals(name, passenger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priorityClass);
    }

    @Override
    public int compareTo(Passenger o) {
        int resultByClass = this.priorityClass-o.priorityClass;
        int resultByName = this.name.compareTo(o.name);
        return resultByClass==0?resultByName:resultByClass;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", priorityClass=" + priorityClass +
                '}';
    }
}
