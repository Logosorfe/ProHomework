package javaHomework.homework16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Uni {
//В JUnit, как было задано по домашней работе, сделал тесты на методы этого класса
    private Map<Integer, Student> students;

    public Uni() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        if (students.size() == 10) {
            throw new UniversityIsFullException("Limit of students is reached");
        } else if (students.containsValue(student)) {
            throw new UniqueStudentException("Student's id is already occupied");
        }
        if (student == null) {
            throw new NullPointerException("Null is not a student");
        } else {
            students.put(student.getId(), student);
        }
    }

    public Student excludeStudent(int id) {
        Student student = students.remove(id);
        if (student == null) {
            throw new NullPointerException("No such student with this id");
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }

    public List<Student> getAllStudents(Degree degree) {
        if (degree == null) {
            throw new NullPointerException("Null is not a degree");
        }
        return students.values().stream()
                .filter((s -> s.getDegree() == degree)).collect(Collectors.toList());
    }

    public int countStudents() {
        return students.size();
    }

    public int countStudents(Degree degree) {
        if (degree == null) {
            throw new NullPointerException("Null is not a degree");
        }
        return (int) students.values().stream()
                .filter((s -> s.getDegree() == degree)).count();
    }

    public int getSumAgeAllStudents() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No students present");
        }
        int sum = 0;
        for (Student student : students.values()) {
            sum += student.getAge();
        }
        return sum;
    }

    public int getSumAgeAllStudents(Degree degree) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No students present");
        } else if (degree == null) {
            throw new NullPointerException("Null is not a degree");
        }
        int sum = 0;
        for (Student student : students.values().stream()
                .filter((s -> s.getDegree() == degree)).toList()) {
            sum += student.getAge();
        }
        return sum;
    }

    public int getAverageAgeStudents() {
        int quantity = students.size();
        if (quantity == 0) {
            throw new ArithmeticException("No students present");
        }
        int sum = 0;
        for (Student student : students.values()) {
            sum += student.getAge();
        }
        return sum / quantity;
    }
}
