package javaHomework.homework11.taskthree;

import java.util.Objects;

public class Patient implements Comparable<Patient> {
    private final short ticketNumber;
    private boolean isCritical;
    private Therapy therapy;

    public Patient(short ticketNumber, boolean isCritical, Therapy therapy) {
        this.ticketNumber = ticketNumber;
        this.isCritical = isCritical;
        this.therapy = therapy;
    }

    public short getTicketNumber() {
        return ticketNumber;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return ticketNumber == patient.ticketNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticketNumber);
    }

    @Override
    public int compareTo(Patient o) {
        int resultByCritical = Boolean.compare(o.isCritical, this.isCritical);
        int resultByTicket = this.ticketNumber - o.ticketNumber;
        return resultByCritical == 0 ? resultByTicket : resultByCritical;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ticketNumber=" + ticketNumber +
                ", isCritical=" + isCritical +
                ", therapy=" + therapy +
                '}';
    }
}
