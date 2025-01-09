package javaHomework.homework16;

public class UniApp {

    public static void main(String[] args) {
        Uni uni = new Uni();
        try {
            uni.addStudent(new Student(1, "John", 23, Degree.BACHELOR));
            uni.addStudent(new Student(2, "Jane", 21, Degree.MASTER));
            uni.addStudent(new Student(3, "Dexter", 19, Degree.MASTER));
            uni.addStudent(new Student(4, "Donald", 18, Degree.BACHELOR));
            uni.addStudent(new Student(5, "Elon", 25, Degree.BACHELOR));
        }catch (UniversityIsFullException | UniqueStudentException | NullPointerException exception){
            System.out.println(exception.getMessage());
        }finally {
            System.out.println(uni.getAllStudents());
        }
    }
}
