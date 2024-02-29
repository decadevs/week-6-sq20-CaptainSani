package org.example.service;

import org.example.model.Library;
import org.example.model.Library2;
import org.example.model.User;

public interface BorrowerService {
    void borrowBookWithPriority(String bookName, User user, Library library);
    void borrowWithoutPriority(String bookName, User user, Library2 library2);

}
