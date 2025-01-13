package javaHomework.homework17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    String[] strings = new String[1];

    @Test
    void testRun() {
        Horse horse = new Horse("Serve-lad", 1, 100, (byte) 0, strings);
        horse.run();
        assertNotNull(strings[0]);
    }

    @Test
    void testRunIfStepIsZeroOrLess() {
        Horse horse = new Horse("Serve-lad", -1, 100, (byte) 0, strings);
        assertThrows(ArithmeticException.class, horse::run);
    }

    @Test
    void testRunIfLoopLengthIsZeroOrLess() {
        Horse horse = new Horse("Serve-lad", 1, -1, (byte) 0, strings);
        assertThrows(ArithmeticException.class, horse::run);
    }
}
