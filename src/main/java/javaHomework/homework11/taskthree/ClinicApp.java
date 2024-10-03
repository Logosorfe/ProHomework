package javaHomework.homework11.taskthree;

import java.util.*;

public class ClinicApp {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        LinkedList<Patient> patientLinkedList = new LinkedList<>();
        int counter = 0;
        do {
            if (!patientLinkedList.isEmpty()) {
                for (int i = 0; i < 7; i++) {
                    patientLinkedList.add(new Patient((short) (counter + 1),
                            random.nextBoolean(), null));
                    counter++;
                }
            } else {
                for (int j = 0; j < 15; j++) {
                    patientLinkedList.add(new Patient((short) (j + 1),
                            random.nextBoolean(), null));
                    counter++;
                }
            }
            Registry registry = new Registry();
            for (int k = 0; k < 7; k++) {
                Therapy therapy;
                int referral = random.nextInt(4);
                switch (referral) {
                    case 0:
                        therapy = Therapy.TESTS;
                        break;
                    case 1:
                        therapy = Therapy.XRAY;
                        break;
                    case 2:
                        therapy = Therapy.SURGEON;
                        break;
                    default:
                        therapy = Therapy.DRESSING;
                }
                patientLinkedList.peekFirst().setTherapy(therapy);
                System.out.println("Patient no. " + patientLinkedList.peek().getTicketNumber()
                        + " is in the registry line & its referral says - " +
                        patientLinkedList.peek().getTherapy().getDescription());
                registry.getPatients().add(patientLinkedList.pollFirst());
            }
            System.out.println();

            Queue<Patient> priorityPatients = new PriorityQueue<>();
            Iterator<Patient> iterator = registry.getPatients().iterator();
            while (iterator.hasNext()) {
                Patient patient = (iterator.next());
                priorityPatients.add(patient);
                System.out.println(patient + " - awaits for a doctor");
                iterator.remove();
            }
            System.out.println();

            while (!priorityPatients.isEmpty()) System.out.println(priorityPatients.poll() +
                    " - visited a doctor & left");

            System.out.println();
            System.out.println("Would you like to continue?\nY/N");
        }while (scanner.nextLine().equalsIgnoreCase("Y"));
    }
}