package com.workshop.workshop.infrastructure.abstract_services;

import com.workshop.workshop.api.dto.request.LoanRequest;
import com.workshop.workshop.api.dto.response.LoanAllResponse;
import com.workshop.workshop.domain.entities.Loan;

public interface ILoanService extends CRUDService<LoanRequest, LoanAllResponse, Long> {
    Loan getLoanById(Long id);
}
