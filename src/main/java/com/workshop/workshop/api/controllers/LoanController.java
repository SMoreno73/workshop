package com.workshop.workshop.api.controllers;

import com.workshop.workshop.api.dto.request.LoanRequest;
import com.workshop.workshop.api.dto.response.LoanAllResponse;
import com.workshop.workshop.infrastructure.abstract_services.ILoanService;
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
@RequestMapping("/loans")
@AllArgsConstructor
public class LoanController {
    @Autowired
    private final ILoanService loanService;

    @PostMapping
    public ResponseEntity<LoanAllResponse> saveLoan(@Validated @RequestBody LoanRequest loanRequest) {
        return ResponseEntity.ok(loanService.create(loanRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanAllResponse> updateLoan(
            @PathVariable Long id,
            @Validated @RequestBody LoanRequest loanRequest
    ) {
        return ResponseEntity.ok(loanService.update(id, loanRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LoanAllResponse>> getLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<LoanAllResponse>> getAllLoans(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(loanService.getAll(pageable));
    }
}
