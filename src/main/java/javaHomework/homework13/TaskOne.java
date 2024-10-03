package javaHomework.homework13;


import java.util.Arrays;
import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> surnames = Arrays.asList(
                "Kennedy",
                "Ivanov",
                "Muhamed",
                "Escobar",
                "Kant"
        );
surnames.stream().filter(s -> s.startsWith("K")).forEach(s -> System.out.println(s));
    }
}
