package org.example.model;

import org.example.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private Role role;
    private List<Book> borrowedBooks;
    private static int counter = 0;
    private int order;

    public User(String name, Role role, List<Book> borrowedBooks) {
        this.name = name;
        this.role = role;
        this.borrowedBooks = borrowedBooks;
        this.order = counter++;
    }
}
