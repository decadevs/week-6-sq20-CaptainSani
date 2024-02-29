package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.PriorityQueue;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    private String name;
    private List<Book> listOfBooks;
    private PriorityQueue<User> borrowers;
    private User librarian;
}
