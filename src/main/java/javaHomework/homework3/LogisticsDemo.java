package javaHomework.homework3;

public class LogisticsDemo {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.fillProducts();
        storage.printProducts("Storage");

        Truck truck = storage.createTruck(storage.getProducts().length);
        storage.loadTruck(storage.getProducts().length, truck);
        storage.printProducts("Storage");
        truck.printProducts();

        Storage warehouse = new Storage(truck.getProducts().length);
        warehouse.unloadTruck(truck.getProducts().length, truck);
        truck.printProducts();
        warehouse.printProducts("Warehouse");
    }
}
