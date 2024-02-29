package org.example.service.Impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.exception.LibraryException;
import org.example.model.Book;
import org.example.model.Library2;
import org.example.service.LibraryService2;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class LibraryService2Impl implements LibraryService2 {
    private Library2 library2;
    @Override
    public void issueBook(String bookName) {
        //lambda expression
        library2.getListOfBooks().stream().filter(book -> book.getTitle().equalsIgnoreCase(bookName)).forEach(book -> {
            library2.getBorrowers().forEach(person -> {
                if (book.getNoOfCopies() > 0) {
                    book.setNoOfCopies(book.getNoOfCopies() - 1);
                    List<Book> borrowedBooks = person.getBorrowedBooks();
                    borrowedBooks.add(book);
                    person.setBorrowedBooks(borrowedBooks);
                    System.out.println(bookName + " is issued to " + person.getName());
                } else {
                    throw new LibraryException("Book has been taken");
                }
            });

        });
    }
}
