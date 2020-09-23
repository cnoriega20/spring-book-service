package com.training.springbookservice.services;

import com.training.springbookservice.domain.Book;

import java.util.List;

public interface BookService {

    Book findByName(String name);

    List<Book> findAll();

    Book save(Book book);

    void delete(Book book);
}
