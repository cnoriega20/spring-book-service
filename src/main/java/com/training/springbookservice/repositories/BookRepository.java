package com.training.springbookservice.repositories;

import com.training.springbookservice.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
    Book findByName(String name);
}