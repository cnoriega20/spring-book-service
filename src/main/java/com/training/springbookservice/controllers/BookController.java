package com.training.springbookservice.controllers;

import com.training.springbookservice.domain.Book;
import com.training.springbookservice.mappers.BookMapper;
import com.training.springbookservice.model.BookDTO;
import com.training.springbookservice.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookService")
public class BookController {

    private final BookService bookService;

    private final BookMapper bookMapper;


    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return new ResponseEntity(bookMapper.booksToBookDTOList(bookService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable("bookId") Long id){
        Book book = bookService.findById(id);
        return new ResponseEntity(bookMapper.mapBookAsBookDTO(book), HttpStatus.OK);
    }

    @GetMapping("/books{bookName}")
    public ResponseEntity<BookDTO> findBookByName(@PathVariable("bookName") String name){
            return new ResponseEntity<>(bookMapper.
                    mapBookAsBookDTO(bookService.findByName(name).get()), HttpStatus.OK);

    }

    @PostMapping("/storeBooks")
    public ResponseEntity<BookDTO> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(
                bookMapper.mapBookAsBookDTO(bookService.save(book)),
                HttpStatus.CREATED);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody Book book, @PathVariable("bookId")Long id) {
        return new ResponseEntity<>(
                bookMapper.mapBookAsBookDTO(
                    bookService.update(book, id)),
                HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@RequestBody Book book, @PathVariable("bookId")Long id){
        bookService.delete(id);
    }



}
