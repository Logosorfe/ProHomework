package javaHomework.homework18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventCreatorTest {

    EventCreator eventCreator = new EventCreator();

    @Test
    void testRun() throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    while (Firewall.eventSet.isEmpty()) {
                        Thread.sleep(1);
                    }
                    Firewall.isEventCreatorStopped.set(true);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        eventCreator.run();

        assertTrue(Firewall.eventSet.stream().anyMatch((o) -> o.getEventId() == Firewall.eventSet.size()));
    }

    @Test
    void testRunIfAtomicBooleanIsWrong() {

        Firewall.isEventCreatorStopped.set(true);

        assertThrows(IllegalStateException.class, () -> eventCreator.run());
    }

    @Test
    void testRunIfSetIsWrong() {

        Firewall.eventSet = null;

        assertThrows(IllegalStateException.class, () -> eventCreator.run());
    }

    @Test
    void testRunIfIntegerIsWrong() {

        Firewall.counter = -1;

        assertThrows(IllegalStateException.class, () -> eventCreator.run());
    }

    @Test
    void testRunIfUserListIsWrong() {

        Firewall.users = null;

        assertThrows(IllegalStateException.class, () -> eventCreator.run());
    }
}