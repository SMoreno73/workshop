package com.workshop.workshop.infrastructure.services;

import com.workshop.workshop.api.dto.request.LoanRequest;
import com.workshop.workshop.api.dto.response.LoanAllResponse;
import com.workshop.workshop.domain.entities.Book;
import com.workshop.workshop.domain.entities.Loan;
import com.workshop.workshop.domain.entities.User;
import com.workshop.workshop.domain.repositories.LoanRepository;
import com.workshop.workshop.infrastructure.abstract_services.IBookService;
import com.workshop.workshop.infrastructure.abstract_services.ILoanService;
import com.workshop.workshop.infrastructure.abstract_services.IUserService;
import com.workshop.workshop.infrastructure.helpers.mappers.LoanMapper;
import com.workshop.workshop.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {
    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final LoanMapper loanMapper;

    @Autowired
    private final IUserService userService;

    @Autowired
    private final IBookService bookService;

    @Override
    public LoanAllResponse create(LoanRequest loanRequest) {
        Loan loan = loanMapper.toLoan(loanRequest);

        User existingUser = userService.getUserById(loanRequest.getUserId());
        Book existingBook = bookService.getBookById(loanRequest.getBookId());

        loan.setUserId(existingUser);
        loan.setBookId(existingBook);

        return loanMapper.toLoanResponse(loanRepository.save(loan));
    }

    @Override
    public LoanAllResponse update(Long id, LoanRequest loanRequest) {
        Loan existingLoan = getLoanById(id);
        User existingUser = userService.getUserById(loanRequest.getUserId());
        Book existingBook = bookService.getBookById(loanRequest.getBookId());

        existingLoan.setUserId(existingUser);
        existingLoan.setBookId(existingBook);

        return loanMapper.toLoanResponse(loanRepository.save(existingLoan));
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public Page<LoanAllResponse> getAll(Pageable pageable) {
        Page<Loan> loanPage = loanRepository.findAll(pageable);
        return loanPage.map(loanMapper::toLoanResponse);
    }

    @Override
    public Optional<LoanAllResponse> getById(Long id) {
        Optional<Loan> loan = loanRepository.findById(id);
        if (loan.isEmpty()) throw new IdNotFoundException("QUESTION", id);
        return loan.map(loanMapper::toLoanResponse);
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("LOAN", id));
    }
}
