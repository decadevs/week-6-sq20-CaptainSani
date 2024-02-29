package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Queue;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Library2 {
    private String name;
    private List<Book> listOfBooks;
    private Queue<User> borrowers;
    private User librarian;
}
