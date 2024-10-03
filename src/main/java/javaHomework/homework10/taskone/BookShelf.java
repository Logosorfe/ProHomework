package javaHomework.homework10.taskone;

import java.util.*;

public class BookShelf {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.bookList.add(new Book("War & Peace", 1869,
                1225, new Author("Leo Tolstoy", 1828)));
        shelf.bookList.add(new Book("Kobzar", 1840,
                115, new Author("Taras Shevchenko", 1814)));
        shelf.bookList.add(new Book("What Is to Be Done?", 1863,
                864, new Author("Nikolay Chernyshevsky", 1828)));
        shelf.bookList.add(new Book("The Grapes of Wrath", 1939,
                464, new Author("John Steinbeck", 1902)));
        shelf.bookList.add(new Book("The Adventures of Tom Sawyer", 1876,
                296, new Author("Mark Twain", 1835)));
        shelf.bookList.add(new Book("Oliver Twist", 1838,
                608, new Author("Charles Dickens", 1812)));
        shelf.bookList.add(new Book("The Tale of Khoja Nasreddin", 1956,
                672, new Author("Leonid Solovyov", 1906)));
        shelf.bookList.add(new Book("Moloch", 1896,
                133, new Author("Alexander Kuprin", 1870)));
        shelf.bookList.add(new Book("Aesop's Fables", 0,
                262, new Author("Unknown", 0)));
        shelf.bookList.add(new Book("Das Kapital", 1867,
                356, new Author("Karl Marx", 1818)));

        SortByTitle sortByTitle = new SortByTitle();
        Set<Book> titleSet = new TreeSet<>(sortByTitle);
        for (int i = 0; i < shelf.getBookList().size(); i++) {
            titleSet.add(shelf.getBookList().get(i));
        }
        System.out.println("Books sorted by title:\n" + titleSet);

        SortByIssueDate sortByIssueDate = new SortByIssueDate();
        Set<Book> issueSet = new TreeSet<>(sortByIssueDate);
        for (int i = 0; i < shelf.getBookList().size(); i++) {
            issueSet.add(shelf.getBookList().get(i));
        }
        System.out.println("Books sorted by date of issue:\n" + issueSet);

        SortedByPageQuantity sortedByPageQuantity = new SortedByPageQuantity();
        Set<Book> pageSet = new TreeSet<>(sortedByPageQuantity);
        for (int i = 0; i < shelf.getBookList().size(); i++) {
            pageSet.add(shelf.getBookList().get(i));
        }
        System.out.println("Books sorted by page's quantity:\n" + pageSet);

        SortByBirthdate sortByBirthdate = new SortByBirthdate();
        Set<Book> birthSet = new TreeSet<>(sortByBirthdate);
        for (int i = 0; i < shelf.getBookList().size(); i++) {
            birthSet.add(shelf.getBookList().get(i));
        }
        System.out.println("Books sorted by author's date of birth:\n" + birthSet);
    }

    private List<Book> bookList;

    public BookShelf() {
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
