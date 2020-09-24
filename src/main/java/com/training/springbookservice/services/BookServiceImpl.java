package com.training.springbookservice.services;

import com.training.springbookservice.domain.Book;
import com.training.springbookservice.exceptions.BookNotFoundException;
import com.training.springbookservice.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name);
        /*return Optional.ofNullable(Optional.of(bookRepository.findByName(name)).
                orElseThrow(() -> new BookNotFoundException(name)));*/

    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book updatedBook, Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setName(updatedBook.getName());
                    book.setGenre(updatedBook.getGenre());
                    book.setWriter(updatedBook.getWriter());
                    book.setYear(updatedBook.getYear());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    updatedBook.setId(id);
                    return bookRepository.save(updatedBook);
                });

    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
