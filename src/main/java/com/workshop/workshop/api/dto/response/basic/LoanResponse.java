package com.workshop.workshop.api.dto.response.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private Long id;

    private Date loanDate;

    private Date returnDate;

    private String status;

}
