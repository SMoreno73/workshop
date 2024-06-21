package com.workshop.workshop.api.controllers;

import com.workshop.workshop.api.dto.request.BookRequest;
import com.workshop.workshop.api.dto.response.BookAllResponse;
import com.workshop.workshop.infrastructure.abstract_services.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    @Autowired
    private final IBookService bookService;

    @PostMapping
    public ResponseEntity<BookAllResponse> saveBook(@Validated @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.create(bookRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookAllResponse> updateBook(
            @PathVariable Long id,
            @Validated @RequestBody BookRequest bookRequest
    ) {
        return ResponseEntity.ok(bookService.update(id, bookRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookAllResponse>> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<BookAllResponse>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(bookService.getAll(pageable));
    }
}
