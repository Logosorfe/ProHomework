package javaHomework.homework10;

import java.util.*;

public class CarSaleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarSaleApp csa = new CarSaleApp();

        System.out.println("Enter sold car data");
        Set<Car> tempSet = new TreeSet<>();
        do {
            System.out.println("Enter brand");
            String brand = scanner.nextLine().toUpperCase();

            System.out.println("Enter color");
            String color = scanner.nextLine().toUpperCase();

            System.out.println("Enter VIN number");
            String vinNumber = scanner.nextLine().toUpperCase();
            while (vinNumber.length() != 17) {
                System.out.println("Incorrect VIN number\nEnter VIN number");
                vinNumber = scanner.nextLine().toUpperCase();
            }

            System.out.println("Enter license plate");
            String licensePlate = scanner.nextLine().toUpperCase();

            System.out.println("Is car on lease?\ntrue/false");
            boolean isOnLease = scanner.nextBoolean();
            scanner.nextLine();

            tempSet.add(new Car(brand, color, vinNumber, licensePlate, isOnLease));

            System.out.println("Add another car?\nY/N");
        } while (scanner.nextLine().equalsIgnoreCase("y"));

        System.out.println("\nOriginal list of sold cars:");
        for (Car car : tempSet) {
            csa.soldCarList.add(car);
            if (car.getIsOnLease()) {
                csa.leasedCarSet.add(car);
            }
            System.out.println(car);
        }

        while (true) {
            System.out.println("\nIs car being sold again?\nY/N");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Enter its' VIN number");
                String vinNumber = scanner.nextLine().toUpperCase();
                boolean correctVin = false;
                System.out.println("Has color been changed\nY/N");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    do {
                        for (int i = 0; i < csa.soldCarList.size(); i++) {
                            if (vinNumber.equals(csa.soldCarList.get(i).getVinNumber())) {
                                System.out.println("Enter new color");
                                csa.soldCarList.get(i).setColor(scanner.nextLine().toUpperCase());
                                csa.soldCarList.get(i).setIsOnLease(false);
                                correctVin = true;
                                break;
                            }
                        }
                        if (!correctVin) {
                            System.out.println("Incorrect VIN number\nEnter VIN number");
                            vinNumber = scanner.nextLine().toUpperCase();
                        }
                    } while (!correctVin);
                }
                System.out.println("Has license plate been changed\nY/N");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    do {
                        for (int i = 0; i < csa.soldCarList.size(); i++) {
                            if (vinNumber.equals(csa.soldCarList.get(i).getVinNumber())) {
                                System.out.println("Enter new license plate");
                                csa.soldCarList.get(i).setLicensePlate(scanner.nextLine().toUpperCase());
                                csa.soldCarList.get(i).setIsOnLease(false);
                                correctVin = true;
                                break;
                            }
                        }
                        if (!correctVin) {
                            System.out.println("Incorrect VIN number\nEnter VIN number");
                            vinNumber = scanner.nextLine().toUpperCase();
                        }
                    } while (!correctVin);
                }
                System.out.println("Changing lease status...");
                do {
                    for (int i = 0; i < csa.soldCarList.size(); i++) {
                        if (vinNumber.equals(csa.soldCarList.get(i).getVinNumber())) {
                            csa.soldCarList.get(i).setIsOnLease(false);
                            correctVin = true;
                            break;
                        }
                    }
                    if (!correctVin) {
                        System.out.println("Incorrect VIN number\nEnter VIN number");
                        vinNumber = scanner.nextLine().toUpperCase();
                    }
                } while (!correctVin);
            } else break;
        }

        System.out.println("\nCars that are still on lease:");
        for (Car car : csa.soldCarList) {
            if (csa.leasedCarSet.contains(car)) System.out.println(car);
        }

        System.out.println("Updated list of sold cars:\n");
        for (Car car : csa.soldCarList) System.out.println(car);
    }

    private List<Car> soldCarList;

    private Set<Car> leasedCarSet;

    public CarSaleApp() {
        this.soldCarList = new ArrayList<>();
        this.leasedCarSet = new HashSet<>();
    }
}
