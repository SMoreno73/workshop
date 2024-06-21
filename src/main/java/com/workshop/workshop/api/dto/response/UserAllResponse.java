package com.workshop.workshop.api.dto.response;

import com.workshop.workshop.api.dto.response.basic.BookResponse;
import com.workshop.workshop.api.dto.response.basic.ReservationResponse;
import com.workshop.workshop.api.dto.response.basic.UserResponse;

import java.util.List;

public class UserAllResponse extends UserResponse {
    private List<BookResponse> books;

    private List<ReservationResponse> reservations;
}
