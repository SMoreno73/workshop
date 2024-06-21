package com.workshop.workshop.api.dto.response;

import com.workshop.workshop.api.dto.response.basic.BookResponse;
import com.workshop.workshop.api.dto.response.basic.LoanResponse;
import com.workshop.workshop.api.dto.response.basic.ReservationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookAllResponse extends BookResponse {
    private List<LoanResponse> loans;

    private List<ReservationResponse> reservations;
}
