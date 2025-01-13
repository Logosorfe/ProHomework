package javaHomework.homework17;

import java.time.LocalTime;

public class Horse implements Runnable {

    private final String name;

    private final int step;

    private final int loopLength;

    private int currentPosition;

    private final byte index;

    private final String[] result;

    public Horse(String name, int step, int loopLength, byte index, String[] result) {
        this.name = name;
        this.step = step + 1;
        this.loopLength = loopLength;
        this.index = index;
        this.result = result;
    }

    @Override
    public void run() {
        while (currentPosition < loopLength) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentPosition += step;
            System.out.println("Horse " + name + " step by " + currentPosition);
        }
        result[index] = ("I am " + name + " finish time " + LocalTime.now());
    }
}
