package javaHomework.homework18;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Firewall {/**Ну и само собой сделал тесты на методы этого класса*/

    public static AtomicBoolean isEventCreatorStopped = new AtomicBoolean();
    public static int counter;
    public static Set<Event> eventSet = new TreeSet<>((o1, o2) -> o1.getEventId() - o2.getEventId());
    public static List<String> logList = new ArrayList<>();
    public static List<String> users = List.of(
            "MysticVoyager",
            "PixelPioneer",
            "NebulaNinja",
            "QuantumQuester",
            "StellarScribe",
            "GalacticGamer",
            "CosmicCrafter",
            "LunarLynx",
            "SolarSorcerer",
            "AstralAdventurer");


    public Set<Event> setCreator() throws InterruptedException {

        Thread eventCreator = new EventCreator();

        Thread threadOne = new Thread(eventCreator);
        Thread threadTwo = new Thread(eventCreator);
        Thread threadThree = new Thread(eventCreator);
        Thread threadFour = new Thread(eventCreator);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        while (eventSet.isEmpty()) {
            Thread.sleep(1);
        }

        isEventCreatorStopped.set(true);

        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();

        return eventSet;
    }

    public List<String> logCreator() {

        Iterator<Event> eventIterator = eventSet.iterator();

        new Thread(new FirewallEventListener(eventIterator)).start();
        new Thread(new FirewallEventListener(eventIterator)).start();
        new Thread(new FirewallEventListener(eventIterator)).start();
        new Thread(new FirewallEventListener(eventIterator)).start();

        while (logList.size() != 4 * eventSet.size()) {
            System.out.print("");
        }

        return logList;
    }
}

