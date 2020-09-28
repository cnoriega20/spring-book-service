package com.training.springbookservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.springbookservice.domain.Book;
import com.training.springbookservice.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Autowired
    ObjectMapper objectMapper;

    private List<Book> books;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        books.add(Book.builder()
                .name("Madame Bovary")
                .genre("Drama")
                .writer("Gustave Flaubert")
                .year("1856")
                .build());

        books.add(Book.builder()
                .name("Methamorphosis")
                .genre("Horror")
                .writer("Franz Kafka")
                .year("1856")
                .build());
    }

    @Test
    void testGetAllBooks() throws Exception {
        given(bookService.findAll()).willReturn(books);

        mockMvc.perform(get("/api/v1/bookService/books").
                accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.size()", books.size()));
    }

    @Test
    void testFindBookById() {
    }

    @Test
    void testFindBookByName() {
    }

    @Test
    void testSaveBook() {
    }

    @Test
    void testUpdateBook() {
    }

    @Test
    void testDeleteBook() {
    }
}