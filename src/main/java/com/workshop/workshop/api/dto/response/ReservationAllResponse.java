package com.workshop.workshop.api.dto.response;

import com.workshop.workshop.api.dto.response.basic.BookResponse;
import com.workshop.workshop.api.dto.response.basic.ReservationResponse;
import com.workshop.workshop.api.dto.response.basic.UserResponse;
import com.workshop.workshop.domain.entities.Book;
import com.workshop.workshop.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationAllResponse extends ReservationResponse {
    private UserResponse userId;

    private BookResponse bookId;
}
