package com.workshop.workshop.infrastructure.services;

import com.workshop.workshop.api.dto.request.BookRequest;
import com.workshop.workshop.api.dto.response.BookAllResponse;
import com.workshop.workshop.domain.entities.Book;
import com.workshop.workshop.domain.repositories.BookRepository;
import com.workshop.workshop.infrastructure.abstract_services.IBookService;
import com.workshop.workshop.infrastructure.helpers.mappers.BookMapper;
import com.workshop.workshop.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookMapper bookMapper;

    @Override
    public BookAllResponse create(BookRequest bookRequest) {
        Book book = bookMapper.toBook(bookRequest);
        return bookMapper.toBookResponse(bookRepository.save(book));
    }

    @Override
    public BookAllResponse update(Long id, BookRequest bookRequest) {
        Book existingBook = getBookById(id);
        bookMapper.updateFromBookRequest(bookRequest, existingBook);
        Book updateBook = bookRepository.save(existingBook);
        return bookMapper.toBookResponse(updateBook);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<BookAllResponse> getAll(Pageable pageable) {
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return bookPage.map(bookMapper::toBookResponse);
    }

    @Override
    public Optional<BookAllResponse> getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new IdNotFoundException("BOOK", id);
        return book.map(bookMapper::toBookResponse);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("BOOK", id));
    }
}
