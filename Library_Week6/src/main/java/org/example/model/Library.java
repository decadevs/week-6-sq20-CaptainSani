package org.example.model;

import org.example.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Book;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Library {
    private String name;
    private List<Book> listOfBooks = new ArrayList<>();
    private PriorityQueue<User> borrowers = new PriorityQueue<>();
    private Queue<User> userQueueFIFO = new LinkedList<>();
    private User librarian;


}