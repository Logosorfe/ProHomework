package javaHomework.homework15.taskone;

import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        BookStorage bookStorage = new BookStorage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter new Book\nEnter isbn number");
            int bookNumber = scanner.nextInt();
            System.out.println("Enter title");
            String bookName = scanner.next();
            bookStorage.addBook(new Book(bookName, bookNumber));
            System.out.println("Would you like to add another book?\nY/N");
            if (scanner.next().equalsIgnoreCase("N")) break;
        }

        System.out.println("What is the ISBN of the book you are looking for?");
        System.out.println(bookStorage.getBook(scanner.nextInt()));

        System.out.println(bookStorage.getBookMap());
    }
}
