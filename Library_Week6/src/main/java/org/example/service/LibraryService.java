package org.example.service;

import org.example.model.Library;
import org.example.model.User;
public interface LibraryService {

    public void giveBook(String titleOfBook, Library library);

    public void giveBookFIFO(String titleOfBook, Library library);

}
