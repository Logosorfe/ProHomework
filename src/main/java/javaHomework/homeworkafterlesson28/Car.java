package javaHomework.homeworkafterlesson28;

import java.util.concurrent.Semaphore;

public class Car extends Thread {

    private Semaphore semaphore;
    private boolean[] isGasPumpTaken;
    private int id;

    public Car(Semaphore semaphore, boolean[] isGasPumpTaken, int id) {
        this.semaphore = semaphore;
        this.isGasPumpTaken = isGasPumpTaken;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Car with id " + id + " has arrived at the gas station.");

        int tempNumber = -1;
        try {
            semaphore.acquire();
            synchronized (isGasPumpTaken) {
                for (int i = 0; i < isGasPumpTaken.length; i++) {
                    if (!isGasPumpTaken[i]) {
                        isGasPumpTaken[i] = true;
                        tempNumber = i;
                        break;
                    }
                }
            }
            System.out.println("Car with id " + id + " is filling up the tank.");
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        isGasPumpTaken[tempNumber]=false;
        System.out.println("Car with id " + id + " has left the gas station");
        semaphore.release();
    }
}
