package javaHomework.homework10.taskone;

import java.util.Objects;

public class Book {
    private String title;

    private int issueDate;

    private int pageQuantity;

    private Author author;

    public Book(String title, int issueDate, int pageQuantity, Author author) {
        this.title = title;
        this.issueDate = issueDate;
        this.pageQuantity = pageQuantity;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(int issueDate) {
        this.issueDate = issueDate;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return issueDate == book.issueDate && pageQuantity == book.pageQuantity && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, issueDate, pageQuantity, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", dateOfIssue=" + issueDate +
                ", pageQuantity=" + pageQuantity +
                ", author=" + author +
                '}';
    }
}
