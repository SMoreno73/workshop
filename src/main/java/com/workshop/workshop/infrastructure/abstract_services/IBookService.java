package com.workshop.workshop.infrastructure.abstract_services;

import com.workshop.workshop.api.dto.request.BookRequest;
import com.workshop.workshop.api.dto.response.BookAllResponse;
import com.workshop.workshop.domain.entities.Book;

public interface IBookService extends CRUDService<BookRequest, BookAllResponse, Long> {
    Book getBookById(Long id);
}
