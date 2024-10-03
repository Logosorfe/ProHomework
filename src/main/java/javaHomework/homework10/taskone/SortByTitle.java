package javaHomework.homework10.taskone;

import java.util.Comparator;

public class SortByTitle implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int resultByTitle = o1.getTitle().compareTo(o2.getTitle());
        int resultByName = o1.getAuthor().getName().compareTo(o2.getAuthor().getName());
        return resultByTitle == 0 ? resultByName : resultByTitle;
    }
}
