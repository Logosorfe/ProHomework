package javaHomework.homework10.taskone;

import java.util.Comparator;

public class SortByBirthdate implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int resultByBirthDate = o1.getAuthor().getBirthDate() - o2.getAuthor().getBirthDate();
        int resultByName = o1.getAuthor().getName().compareTo(o2.getAuthor().getName());
        return resultByBirthDate == 0 ? resultByName : resultByBirthDate;
    }
}
