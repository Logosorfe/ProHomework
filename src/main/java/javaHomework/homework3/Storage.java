package javaHomework.homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Storage {
    private Product[] products;

    public Storage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter products' quantity");
        int numberOfProducts = scanner.nextInt();
        while (numberOfProducts < 3 || numberOfProducts > 5) {
            System.out.println("Wrong number");
            System.out.println("Enter products quantity");
            numberOfProducts = scanner.nextInt();
        }
        this.products = new Product[numberOfProducts];
    }

    public Storage(int numberOfProducts) {
        this.products = new Product[numberOfProducts];
    }

    public Product[] getProducts() {
        return products;
    }

    public void fillProducts() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.products.length; i++) {
            if (i % 3 == 0) {
                System.out.println("Enter book's name");
                this.products[i] = new BookProduct(scanner.nextLine());
            } else if (i / 2 == 1) {
                System.out.println("Enter food's name");
                this.products[i] = new FoodProduct(scanner.nextLine());
            } else {
                System.out.println("Enter tech's name");
                this.products[i] = new TechProduct(scanner.nextLine());
            }
        }
    }

    public void printProducts(String typeOfStorage) {
        System.out.println("Current list of products in " + typeOfStorage);
        System.out.println("START OF LIST");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getClass() + " = " + product);
            }
        }
        System.out.println("END OF LIST");
    }

    public Truck createTruck(int numberOfProducts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of products is - " + numberOfProducts);
        System.out.println("Enter 'Small' for 3, either 'Middle' if it equals 4 or 'Big' in case it is 5");
        switch (scanner.next()) {
            case "Small":
                return new SmallTruck(3);
            case "Middle":
                return new MiddleTruck(4);
            default:
                return new BigTruck(5);
        }
    }

    public void loadTruck(int numberOfProducts, Truck truck) {
        if (numberOfProducts == 0) {
            System.out.println("FINISHED");
            return;
        }
        System.out.print("LOADING...");
        truck.getProducts()[numberOfProducts - 1] = this.products[numberOfProducts - 1];
        this.products[numberOfProducts - 1] = null;
        loadTruck(numberOfProducts - 1, truck);
    }

    public void unloadTruck(int numberOfProducts, Truck truck) {
        if (numberOfProducts == 0) {
            System.out.println("FINISHED");
            return;
        }
        System.out.print("UNLOADING...");
        this.products[numberOfProducts - 1] = truck.getProducts()[numberOfProducts - 1];
        truck.getProducts()[numberOfProducts - 1] = null;
        unloadTruck(numberOfProducts - 1, truck);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}
