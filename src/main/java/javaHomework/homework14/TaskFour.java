package javaHomework.homework14;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TaskFour {
    public static void main(String[] args) throws Exception {
        String saveFolder = "C:/Users/Logosorfe/IdeaProjects/ProHomework/src/main/java/JavaHomework/homework14/savegame";
        Scanner scanner = new Scanner(System.in);
        File saveUniqueCities = new File(saveFolder + "uniquecities.txt");
        File saveNotUniqueCities = new File(saveFolder + "notuniquecities.txt");
        Set<String> uniqueCities = new HashSet<>();
        Set<String> notUniqueCities = new HashSet<>();

        System.out.println("Game starts");
        int counter = 0;
        if (saveUniqueCities.exists() && saveNotUniqueCities.exists()) {
            System.out.println("Do you want to continue game from save?\nY/N");
            if (scanner.next().equalsIgnoreCase("y")) {
                BufferedReader uniqueReader = new BufferedReader(new InputStreamReader(new FileInputStream(saveFolder + "uniquecities.txt")));
                while (uniqueReader.ready()) uniqueCities.add(uniqueReader.readLine());
                uniqueReader.close();

                BufferedReader notUniqueReader = new BufferedReader(new InputStreamReader(new FileInputStream(saveFolder + "notuniquecities.txt")));
                while (notUniqueReader.ready()) notUniqueCities.add(notUniqueReader.readLine());
                notUniqueReader.close();

                FileInputStream counterReader = new FileInputStream(saveFolder + "counter.txt");
                while (counterReader.available() > 0) counter = Character.getNumericValue((char) counterReader.read());
                counterReader.close();
            }
        } else if (saveUniqueCities.exists()) {
            System.out.println("Do you want to continue game from save?\nY/N");
            if (scanner.next().equalsIgnoreCase("y")) {
                BufferedReader uniqueReader = new BufferedReader(new InputStreamReader(new FileInputStream(saveFolder + "uniquecities.txt")));
                while (uniqueReader.ready()) uniqueCities.add(uniqueReader.readLine());
                uniqueReader.close();

                FileInputStream counterReader = new FileInputStream(saveFolder + "counter.txt");
                while (counterReader.available() > 0) counter = Character.getNumericValue((char) counterReader.read());
                counterReader.close();
            }
        }
        System.out.println("First player enter name of a city");

        while (counter < 5) {
            String currentCity = scanner.next();
            if (!uniqueCities.add(currentCity)) {
                notUniqueCities.add(currentCity);
                counter++;
            }
            if (counter < 5) {
                System.out.println("Do you want to save game and exit?\nY/N");
                if (scanner.next().equalsIgnoreCase("y")) {
                    PrintStream saveUnique = new PrintStream(new FileOutputStream(saveFolder + "uniquecities.txt"));
                    for (String temp : uniqueCities) {
                        System.setOut(saveUnique);
                        System.out.println(temp);
                    }
                    saveUnique.close();

                    PrintStream saveNotUnique = new PrintStream(new FileOutputStream(saveFolder + "notuniquecities.txt"));
                    for (String temp : notUniqueCities) {
                        System.setOut(saveNotUnique);
                        System.out.println(temp);
                    }
                    saveNotUnique.close();

                    FileOutputStream saveCounter = new FileOutputStream(saveFolder + "counter.txt");
                    saveCounter.write(String.valueOf(counter).getBytes());
                    saveCounter.close();
                    return;
                }
                System.out.println("Next player enter name of a city");
            }
        }
        scanner.close();

        System.out.println("Every city named:");
        Iterator<String> uniqueCityIterator = uniqueCities.iterator();
        while (uniqueCityIterator.hasNext()) {
            System.out.println(uniqueCityIterator.next());
        }
        System.out.println("Every city named at least twice:");
        Iterator<String> notUniqueCityIterator = notUniqueCities.iterator();
        while (notUniqueCityIterator.hasNext()) {
            System.out.println(notUniqueCityIterator.next());
        }
    }
}