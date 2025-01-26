package javaHomework.homework18;

import java.util.List;
import java.util.Set;

public class FirewallApp {

    public static void main(String[] args) throws InterruptedException {

        Firewall firewall = new Firewall();

        Set<Event> events = firewall.setCreator();
        System.out.println("Number of events = " + events.size());

        List<String> logs = firewall.logCreator();
        for (String str : logs) System.out.println(str);
        System.out.println("Number of events = " + logs.size());
    }
}