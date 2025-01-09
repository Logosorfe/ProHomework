package javaHomework.homework16;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UniTest {
    private Uni uni;

    @BeforeEach
    public void init() {
        uni = new Uni();
    }

    @Test
    public void testUniInit() {
        Assertions.assertEquals(0, uni.getAllStudents().size());
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(1, "John", 33, Degree.MASTER);
        uni.addStudent(student);
        Assertions.assertTrue(uni.getAllStudents().contains(student));
    }

    @Test
    public void testAddStudentWhenLimitIsReached() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        uni.addStudent(new Student(2, "Aaron", 18, Degree.BACHELOR));
        uni.addStudent(new Student(3, "Bill", 19, Degree.MASTER));
        uni.addStudent(new Student(4, "Clark", 20, Degree.MASTER));
        uni.addStudent(new Student(5, "Dick", 21, Degree.BACHELOR));
        uni.addStudent(new Student(6, "Ethan", 22, Degree.MASTER));
        uni.addStudent(new Student(7, "Frank", 23, Degree.MASTER));
        uni.addStudent(new Student(8, "Harry", 24, Degree.BACHELOR));
        uni.addStudent(new Student(9, "Louis", 25, Degree.BACHELOR));
        uni.addStudent(new Student(10, "Mike", 26, Degree.MASTER));
        Assertions.assertThrows(UniversityIsFullException.class,
                () -> uni.addStudent(new Student(11, "Nick", 27, Degree.MASTER)));
    }

    @Test
    public void testAddStudentWhenIdIsOccupied() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        Assertions.assertThrows(UniqueStudentException.class,
                () -> uni.addStudent(new Student(1, "Alex", 21, Degree.BACHELOR)));
    }

    @Test
    public void testAddStudentWhenStudentIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> uni.addStudent(null));
    }

    @Test
    public void testExcludeStudent() {
        Student student = new Student(1, "John", 33, Degree.MASTER);
        uni.addStudent(student);
        Assertions.assertEquals(student, uni.excludeStudent(1));
    }

    @Test
    public void testExcludeStudentWhenStudentIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> uni.excludeStudent(1));
    }

    @Test
    public void testGetAllStudentsWithUniqueDegree() {
        Student student = new Student(1, "John", 33, Degree.MASTER);
        uni.addStudent(student);
        uni.addStudent(new Student(2, "Aaron", 18, Degree.BACHELOR));
        Student studentThree = new Student(3, "Bill", 19, Degree.MASTER);
        uni.addStudent(studentThree);
        Assertions.assertEquals(List.of(student, studentThree), uni.getAllStudents(Degree.MASTER));
    }

    @Test
    public void testGetAllStudentsWhenUniqueDegreeIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> uni.getAllStudents(null));
    }

    @Test
    public void testCountStudents() {
        Assertions.assertEquals(0, uni.countStudents());
    }

    @Test
    public void testCountStudentsWithUniqueDegree() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        uni.addStudent(new Student(2, "Aaron", 18, Degree.BACHELOR));
        uni.addStudent(new Student(3, "Bill", 19, Degree.MASTER));
        Assertions.assertEquals(2, uni.countStudents(Degree.MASTER));
    }

    @Test
    public void testCountStudentsWhenUniqueDegreeIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> uni.countStudents(null));
    }

    @Test
    public void testGetSumAgeAllStudents() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        uni.addStudent(new Student(2, "Aaron", 18, Degree.BACHELOR));
        Assertions.assertEquals(51, uni.getSumAgeAllStudents());
    }

    @Test
    public void testGetSumAgeAllStudentsWhenNoStudent() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> uni.getSumAgeAllStudents());
    }

    @Test
    public void testGetSumAgeAllStudentsWithUniqueDegree() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        uni.addStudent(new Student(2, "Aaron", 18, Degree.BACHELOR));
        uni.addStudent(new Student(3, "Bill", 19, Degree.MASTER));
        Assertions.assertEquals(52, uni.getSumAgeAllStudents(Degree.MASTER));
    }

    @Test
    public void testGetSumAgeAllStudentsWithUniqueDegreeWhenNoStudent() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> uni.getSumAgeAllStudents(Degree.BACHELOR));
    }

    @Test
    public void testGetSumAgeAllStudentsWhenUniqueDegreeIsNull() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        Assertions.assertThrows(NullPointerException.class,
                () -> uni.getSumAgeAllStudents(null));
    }

    @Test
    public void testGetAverageAgeStudents() {
        uni.addStudent(new Student(1, "John", 33, Degree.MASTER));
        uni.addStudent(new Student(2, "Aaron", 18, Degree.BACHELOR));
        uni.addStudent(new Student(3, "Bill", 19, Degree.MASTER));
        Assertions.assertEquals(23, uni.getAverageAgeStudents());
    }

    @Test
    public void testGetAverageAgeStudentsWhenNoStudent() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> uni.getAverageAgeStudents());
    }
}