package javaHomework.homework18;

import java.util.Iterator;

public class FirewallEventListener implements Runnable {

    private Iterator<Event> eventIterator;

    public FirewallEventListener(Iterator<Event> eventIterator) {
        if (eventIterator == null) {
            throw new NullPointerException("Iterator can not be NULL");
        }
        this.eventIterator = eventIterator;
    }

    @Override
    public void run() {
        if (Firewall.logList == null || !Firewall.logList.isEmpty()) {
            throw new IllegalStateException("Log list must be initialized as empty");
        }
        while (eventIterator.hasNext()) {
            Event event = eventIterator.next();
            synchronized (Firewall.logList) {
                Firewall.logList.add("Обработчик " + Thread.currentThread().getName() + " " + event.getEventId()
                        + " " + event.getUserName());
                Firewall.logList.add("Обработчик " + Thread.currentThread().getName() + " " + event.getEventId()
                        + " " + event.getUserIp());
                Firewall.logList.add("Обработчик " + Thread.currentThread().getName() + " " + event.getEventId()
                        + " " + event.getEventDate());
                Firewall.logList.add("Обработчик " + Thread.currentThread().getName() + " " + event.getEventId()
                        + " " + event.getEventState());
                sleep(1);
            }
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
