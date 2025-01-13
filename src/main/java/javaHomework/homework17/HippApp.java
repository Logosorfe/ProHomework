package javaHomework.homework17;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HippApp {

    public static void main(String[] args) throws InterruptedException {
        int loopLength = 1000;
        Random random = new Random();
        String[] result = new String[4];

        Thread one = new Thread(new Horse("Alex", random.nextInt(10) + 1, loopLength, (byte) 0, result));
        Thread two = new Thread(new Horse("Oleg", random.nextInt(10) + 1, loopLength, (byte) 1, result));
        Thread three = new Thread(new Horse("Max", random.nextInt(10) + 1, loopLength, (byte) 2, result));
        Thread four = new Thread(new Horse("Egor", random.nextInt(10) + 1, loopLength, (byte) 3, result));

        System.out.println("Start : ");

        one.start();
        two.start();
        three.start();
        four.start();

        one.join();
        two.join();
        three.join();
        four.join();

        System.out.println(Arrays.toString(result));
    }
}
