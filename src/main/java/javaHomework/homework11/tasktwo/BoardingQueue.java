package javaHomework.homework11.tasktwo;

import java.util.*;

public class BoardingQueue {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Set<Passenger> passengerSet = new HashSet<>();

        int counter = 0;
        while (counter < 3) {
            System.out.println("Enter passenger's name");
            String name = scanner.nextLine();
            byte priorityClass = (byte) (random.nextInt(2) + 1);
            passengerSet.add(new Passenger(name, priorityClass));
            if (priorityClass == 1) counter++;
        }
        while (passengerSet.size() < 10) {
            System.out.println("Enter passenger's name");
            String name = scanner.nextLine();
            passengerSet.add(new Passenger(name, (byte) 2));
        }
        Queue<Passenger> passengerQueue = new PriorityQueue<>();
        passengerQueue.addAll(passengerSet);

        System.out.println("Boarding starts...\nFirst passenger");
        while (true) {
            System.out.println(passengerQueue.poll());
            if (passengerQueue.isEmpty()) {
                System.out.println("...end of boarding");
                break;
            }
            System.out.println("Next passenger");
        }
    }
}

