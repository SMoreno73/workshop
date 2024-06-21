package com.workshop.workshop.api.dto.response.basic;

import com.workshop.workshop.domain.entities.Book;
import com.workshop.workshop.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private Long id;

    private Date reservationDate;

    private String status;
}
