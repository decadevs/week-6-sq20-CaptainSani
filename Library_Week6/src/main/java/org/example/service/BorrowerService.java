package org.example.service;
import org.example.model.Library;
import org.example.model.User;

public interface BorrowerService {
    public  void requestBook(String titleOfBook, User user, Library library);

    public void requestBookFIFO(String titleOfBook, User user, Library library);


}
