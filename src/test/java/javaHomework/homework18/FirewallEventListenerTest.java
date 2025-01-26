package javaHomework.homework18;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FirewallEventListenerTest {
    EventCreator eventCreator = new EventCreator();

    @Test
    void testRun() {

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

        FirewallEventListener firewallEventListener;
        firewallEventListener = new FirewallEventListener(Firewall.eventSet.iterator());

        firewallEventListener.run();

        assertEquals(4 * Firewall.eventSet.size(), Firewall.logList.size());
    }

    @Test
    void testFirewallEventListenerIfIteratorIsNull() {

        Iterator<Event> eventIterator = null;

        assertThrows(NullPointerException.class, () -> new FirewallEventListener(eventIterator));
    }

    @Test
    void testRunIfLogListIsWrong() {

        FirewallEventListener firewallEventListener;
        firewallEventListener = new FirewallEventListener(Firewall.eventSet.iterator());

        Firewall.logList=null;

        assertThrows(IllegalStateException.class,()->firewallEventListener.run());
    }
}