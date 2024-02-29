package service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.example.model.Library;
import org.example.model.User;
import org.example.model.Book;
import org.example.model.Library2;
import org.example.service.Impl.BorrowerServiceImpl;
import org.junit.jupiter.api.Test;

class BorrowerServiceImplTest {
    @Test
    void testBorrowBookWithPriority() {
        BorrowerServiceImpl borrowerServiceImpl = new BorrowerServiceImpl();
        User person = new User();

        Library library = new Library();
        library.setBorrowers(new PriorityQueue<>());

        borrowerServiceImpl.borrowBookWithPriority("Book Name", person, library);

        assertEquals(1, library.getBorrowers().size());
    }
    @Test
    void testBorrowWithoutPriority() {
        BorrowerServiceImpl borrowerServiceImpl = new BorrowerServiceImpl();
        User person = new User();
        ArrayList<Book> listOfBooks = new ArrayList<>();
        LinkedList<User> borrowers = new LinkedList<>();
        Library2 library2 = new Library2("Name", listOfBooks, borrowers, new User());


        borrowerServiceImpl.borrowWithoutPriority("Book Name", person, library2);
        assertEquals(1, library2.getBorrowers().size());
    }
}