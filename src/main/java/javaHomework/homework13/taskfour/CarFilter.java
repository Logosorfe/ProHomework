package javaHomework.homework13.taskfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFilter {
    public static void main(String[] args) {
        List<Auto> autoList = new ArrayList<>();
        autoList.add(new Auto("GH5003", "red",
                "BMW", 12500, 10000.09f));
        autoList.add(new Auto("KO687", "white",
                "BMW", 35, 25000.89f));
        autoList.add(new Auto("LV0087", "black",
                "Mercedes", 0, 40000.99f));
        autoList.add(new Auto("GB5648", "blue",
                "Mercedes", 4129, 15050.00f));
        autoList.add(new Auto("PL666", "yellow",
                "Toyota", 5640, 12090.39f));
        autoList.add(new Auto("GU0908", "green",
                "Toyota", 500, 32000.99f));
        autoList.add(new Auto("BL3484", "purple",
                "Citroen", 137, 35000.29f));
        autoList.add(new Auto("FA1398", "violet",
                "Peugeot", 0, 45000.00f));
        autoList.add(new Auto("VR3430", "beige",
                "Renault", 0, 50000.00f));
        autoList.add(new Auto("VL3003", "black",
                "Fiat", 0, 11300.67f));

        List<Auto> blackZeros = autoList.stream().
                filter(auto -> auto.getColour().equals("black") && auto.getMileage() == 0).
                collect(Collectors.toList());
        System.out.println("Cars with black colour & 0 mileage:\n" + blackZeros);

        Set<String> expensiveBrands = autoList.stream().
                filter(auto -> auto.getPrice() >= 30000).
                map(Auto::getBrand)
                .collect(Collectors.toSet());
        System.out.println("Brands with prices over $30000:\n" + expensiveBrands);
    }
}
