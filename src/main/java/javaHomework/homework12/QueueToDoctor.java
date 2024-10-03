package javaHomework.homework12;

import java.util.*;

public class QueueToDoctor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Map<String, String>> todayQueue = new TreeMap<>();
        List<String> timeForVisit = new ArrayList<>(Arrays.asList(
                "9:00",
                "9:30",
                "10:00",
                "10:30",
                "11:00",
                "11:30",
                "13:00",
                "13:30"
        ));
        while (!timeForVisit.isEmpty()) {
            System.out.println("Enter your name");
            String name = scanner.nextLine();
            while (true) {
                System.out.println("Enter time for a visit");
                System.out.println(timeForVisit);
                String time = scanner.nextLine();
                if (timeForVisit.contains(time)) {
                    switch (time){
                        case "9:00":
                            todayQueue.put(1,Map.of(time,name));
                            break;
                        case "9:30":
                            todayQueue.put(2,Map.of(time,name));
                            break;
                        case "10:00":
                            todayQueue.put(3,Map.of(time,name));
                            break;
                        case "10:30":
                            todayQueue.put(4,Map.of(time,name));
                            break;
                        case "11:00":
                            todayQueue.put(5,Map.of(time,name));
                            break;
                        case "11:30":
                            todayQueue.put(6,Map.of(time,name));
                            break;
                        case "13:00":
                            todayQueue.put(7,Map.of(time,name));
                            break;
                        default:
                            todayQueue.put(8,Map.of(time,name));
                    }
                    timeForVisit.remove(time);
                    break;
                }
                System.out.println("Wrong time");
            }
        }
        System.out.println("Patients for today\n" + todayQueue);
    }
}
