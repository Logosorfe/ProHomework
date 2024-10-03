package javaHomework.homework10.taskone;

import java.util.Comparator;

public class SortByIssueDate implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int resultByIssueDate = o1.getIssueDate() - o2.getIssueDate();
        int resultByName = o1.getAuthor().getName().compareTo(o2.getAuthor().getName());
        return resultByIssueDate == 0 ? resultByName : resultByIssueDate;
    }
}
