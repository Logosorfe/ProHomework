package javaHomework.homework13;

import java.util.Arrays;

public class TaskTwo {
    public static void main(String[] args) {
        String[]stringArray=new String[]{
                "queue",
                "work",
                "eternity",
                "rod",
                "tree",
                "yoghurt",
                "union",
                "ideology",
                "optimism",
                "party"
        };
        Arrays.stream(stringArray).sorted().forEach(System.out::println);
    }
}
