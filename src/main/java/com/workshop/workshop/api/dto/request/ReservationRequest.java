package com.workshop.workshop.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @NotNull(message = "Reservation date is required")
    @FutureOrPresent(message = "It is not possible to enter a date later than the current date.")
    private Date reservationDate;

    @NotBlank(message = "Status must not be null")
    @Size(
            max = 20,
            message = "Status cannot be longer than 20 characters."
    )
    private String status;

    @NotNull(message = "User id is required")
    @Min(value = 1, message = "User id must be greater than 0")
    private Long userId;

    @NotNull(message = "Book id is required")
    @Min(value = 1, message = "Book id must be greater than 0")
    private Long bookId;
}
