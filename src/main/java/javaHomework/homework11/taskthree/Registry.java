package javaHomework.homework11.taskthree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Registry {
    private Queue<Patient>patients;

    public Registry() {
        this.patients = new ArrayDeque<>();
    }

    public Queue<Patient> getPatients() {
        return patients;
    }
}
