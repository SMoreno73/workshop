package com.workshop.workshop.infrastructure.helpers.mappers;

import com.workshop.workshop.api.dto.request.LoanRequest;
import com.workshop.workshop.api.dto.response.LoanAllResponse;
import com.workshop.workshop.domain.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bookId.id", source = "bookId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    Loan toLoan(LoanRequest loanRequest);

    LoanAllResponse toLoanResponse(Loan loan);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bookId.id", source = "bookId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    void updateFromLoanRequest(LoanRequest loanRequest, @MappingTarget Loan loan);
}
