package javaHomework.homework3;

import java.util.Arrays;

public abstract class Truck {
    private Product[] products;

    public Truck(int numberOfProducts) {
        this.products = new Product[numberOfProducts];
    }

    public Product[] getProducts() {
        return products;
    }

    public void printProducts() {
        System.out.println("Current list of products in truck");
        System.out.println("START OF LIST");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getClass() + " = " + product);
            }
        }
        System.out.println("END OF LIST");
    }

    @Override
    public String toString() {
        return "Truck{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}
