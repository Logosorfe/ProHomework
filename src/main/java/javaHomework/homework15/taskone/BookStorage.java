package javaHomework.homework15.taskone;

import java.util.HashMap;
import java.util.Map;

public class BookStorage {
    private Map<Integer, Book> bookMap;

    public BookStorage() {
        bookMap = new HashMap<>();
    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public void addBook(Book book) {
        if (bookMap.size() < 10) {
            bookMap.put(book.getIsbn(), book);
        } else throw new StorageFullException("Storage is full!");
    }

    public Book getBook(int isbn) {
        for (Map.Entry<Integer, Book> entry : bookMap.entrySet()) {
            if (entry.getKey() == isbn) {
                return entry.getValue();
            }
        }
        throw new NoSuchBookException("Book is not found");
    }
}
