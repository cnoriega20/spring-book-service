package com.training.springbookservice.mappers;

import com.training.springbookservice.domain.Book;
import com.training.springbookservice.model.BookDTO;
import org.mapstruct.Mapper;


@Mapper
public interface BookMapper {

    Book mapBookDTOAsBook(BookDTO bookDTO);

    BookDTO mapBookAsBookDTO(Book book);
}
