package org.example.service.Impl;

import org.example.enums.Role;
import org.example.exception.LibraryException;
import org.example.model.Library;
import org.example.model.Library2;
import org.example.model.User;
import org.example.service.BorrowerService;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

public class BorrowerServiceImpl implements BorrowerService {
    @Override
    public void borrowBookWithPriority(String bookName, User user, Library library1) {
        PriorityQueue<User> borrowers = new PriorityQueue<>((p1, p2) -> {
            int roleValue1 = getRoleValue.apply(p1.getRole());
            int roleValue2 = getRoleValue.apply(p2.getRole());
            if (roleValue1 == roleValue2){
                return Integer.compare(p1.getOrder(), p2.getOrder());
            }
            return roleValue1 - roleValue2;
        });
        borrowers.add(user);
        borrowers.addAll(library1.getBorrowers());
        library1.setBorrowers(borrowers);
    }

    @Override
    public void borrowWithoutPriority(String bookName, User user, Library2 library2) {
        Queue<User> borrowers = library2.getBorrowers();
        borrowers.add(user);
        library2.setBorrowers(borrowers);
    }

    private final Function<Role, Integer> getRoleValue = role -> switch (role) {
        case TEACHER -> 1;
        case SENIOR_STUDENT -> 2;
        case JUNIOR_STUDENT -> 3;
        default -> throw new LibraryException("Unknown role: " + role);
    };
}
