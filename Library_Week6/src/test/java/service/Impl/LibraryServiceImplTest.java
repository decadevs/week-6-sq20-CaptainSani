package service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.example.enums.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.Book;
import org.example.model.Library;
import org.example.model.User;
import org.example.service.BorrowerService;
import org.example.service.Impl.BorrowerServiceImpl;
import org.example.service.Impl.LibraryServiceImpl;
import org.example.service.LibraryService;
import org.junit.jupiter.api.Test;

@NoArgsConstructor
@AllArgsConstructor
class LibraryServiceImplTest {
    @Test
    void testIssueBook() {
        User john = new User("John", Role.JUNIOR_STUDENT, new ArrayList<>());
        User james = new User("James", Role.SENIOR_STUDENT, new ArrayList<>());
        User shamah = new User("Shamah", Role.TEACHER, new ArrayList<>());
        User mathew = new User("Mathew", Role.TEACHER, new ArrayList<>());
        User librarian = new User("Librarian", Role.LIBRARIAN, new ArrayList<>());

        Book efj = new Book("Effective Java", "Joshua Bloch", 6);
        Book htdp = new Book("How to Design", "Matthias Felleisen", 5);
        Book cc = new Book("Clean Code", "Robert C. Martin", 7);

        Library library1 = new Library("Central Library", new ArrayList<>(), new PriorityQueue<>(), librarian);

        library1.setListOfBooks(List.of(efj, htdp, cc));

        LibraryService libraryService1 = new LibraryServiceImpl();

        BorrowerService borrowerService = new BorrowerServiceImpl();

        //When the same book is borrowed by multiple people, the person with the highest priority should be given the book first.
        borrowerService.borrowBookWithPriority("Effective Java", james, library1);
        borrowerService.borrowBookWithPriority("Effective Java", john, library1);
        borrowerService.borrowBookWithPriority("Effective Java", shamah, library1);
        borrowerService.borrowBookWithPriority("Effective Java", mathew, library1);
        libraryService1.issueBook("Effective Java");
        assertEquals(1, james.getBorrowedBooks().size());
        assertEquals("Shamah",library1.getBorrowers().peek().getName());
    }
}