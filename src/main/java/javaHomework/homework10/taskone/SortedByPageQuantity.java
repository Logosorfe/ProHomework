package javaHomework.homework10.taskone;

import java.util.Comparator;

public class SortedByPageQuantity implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int resultByPage = o1.getPageQuantity() - o2.getPageQuantity();
        int resultByName = o1.getAuthor().getName().compareTo(o2.getAuthor().getName());
        return resultByPage == 0 ? resultByName : resultByPage;
    }
}
