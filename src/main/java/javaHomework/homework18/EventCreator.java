package javaHomework.homework18;

import java.time.LocalDate;
import java.util.Random;

public class EventCreator extends Thread {

    @Override
    public void run() {
        if (Firewall.isEventCreatorStopped == null || Firewall.isEventCreatorStopped.get()) {
            throw new IllegalStateException("Atomic boolean must be false from the start");
        }
        if (Firewall.eventSet == null || !Firewall.eventSet.isEmpty()) {
            throw new IllegalStateException("Set must be initialized as empty");
        }
        if (Firewall.counter != 0) {
            throw new IllegalStateException("Atomic integer must be zero");
        }
        if (Firewall.users == null || Firewall.users.isEmpty()) {
            throw new IllegalStateException("Username list must be filled with usernames");
        }

        Random random = new Random();
        EventState[] events = EventState.values();
        while (!Firewall.isEventCreatorStopped.get()) {
            synchronized (this) {
                Firewall.eventSet.add(new Event(++Firewall.counter,
                        Firewall.users.get(random.nextInt(Firewall.users.size())),
                        String.valueOf(random.nextInt(256)) + "."
                                + String.valueOf(random.nextInt(256)) + "."
                                + String.valueOf(random.nextInt(256)) + "."
                                + String.valueOf(random.nextInt(256)),
                        LocalDate.now(),
                        events[random.nextInt(events.length)]));
            }
        }
    }
}
