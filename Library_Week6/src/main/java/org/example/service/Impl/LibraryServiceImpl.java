package org.example.service.Impl;

import org.example.model.Book;
import org.example.model.Library;
import org.example.service.LibraryService;

import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor

public class LibraryServiceImpl implements LibraryService {
    private Library library;

    @Override
    public void issueBook(String bookName) {
        library.getListOfBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(bookName))
                .forEach(book -> library.getBorrowers().stream()
                        .filter(person -> book.getNoOfCopies() > 0)
                        .forEach(person -> {
                            book.setNoOfCopies(book.getNoOfCopies() - 1);
                            List<Book> borrowedBooks = person.getBorrowedBooks();
                            borrowedBooks.add(book);
                            person.setBorrowedBooks(borrowedBooks);
                            System.out.println(bookName + " is issued to " + person.getName());
                        }));
    }
}
