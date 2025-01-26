package javaHomework.homework18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FirewallTest {

    Firewall firewall = new Firewall();

    @Test
    void testIfMultipleThreadsWorkWithTheSameListSimultaneously() throws InterruptedException {

        firewall.setCreator();

        List<String> logs = firewall.logCreator();

        String regexOne = "Thread-5";
        String regexTwo = "Thread-6";
        String regexThree = "Thread-7";
        String regexFour = "Thread-8";

        Pattern compiler = Pattern.compile(regexOne + "|" + regexTwo + "|" + regexThree
                + "|" + regexFour);

        for (String str : logs) System.out.println(str);

        Assertions.assertTrue(Firewall.logList.stream()
                .allMatch((str) -> compiler.matcher(str).find()));
    }
}