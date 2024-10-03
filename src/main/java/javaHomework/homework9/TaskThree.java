package javaHomework.homework9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TaskThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<City> uniqueCities = new HashSet<>();
        Set<City> notUniqueCities = new HashSet<>();

        System.out.println("Game starts");
        System.out.println("First player enter name of a city");

        int counter = 0;
        while (counter < 5) {
            City currentCity = new City(scanner.next());
            if (!uniqueCities.add(currentCity)) {
                notUniqueCities.add(currentCity);
                counter++;
            }
            System.out.println("Next player enter name of a city");
        }
        System.out.println("Every city named:");
        Iterator<City> uniqueCityIterator = uniqueCities.iterator();
        while (uniqueCityIterator.hasNext()) {
            System.out.println(uniqueCityIterator.next());
        }
        System.out.println("Every city named at least twice:");
        Iterator<City> notUniqueCityIterator = notUniqueCities.iterator();
        while (notUniqueCityIterator.hasNext()) {
            System.out.println(notUniqueCityIterator.next());
        }
    }
}
