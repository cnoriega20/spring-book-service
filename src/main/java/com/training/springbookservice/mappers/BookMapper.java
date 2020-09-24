package com.training.springbookservice.mappers;

import com.training.springbookservice.domain.Book;
import com.training.springbookservice.model.BookDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface BookMapper {

    Book mapBookDTOAsBook(BookDTO bookDTO);

    BookDTO mapBookAsBookDTO(Book book);

    List<BookDTO> booksToBookDTOList(List<Book> bookList);
}
