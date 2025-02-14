package javaHomework.homeworkafterlesson28;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GasStation {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3, false);

        boolean[] isGasPumpTaken = new boolean[3];

        Random random = new Random();

        while (true){
            new Car(semaphore,isGasPumpTaken,random.nextInt()).start();
            Thread.sleep(700);
        }
    }
}
