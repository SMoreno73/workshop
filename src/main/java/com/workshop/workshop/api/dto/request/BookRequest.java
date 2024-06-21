package com.workshop.workshop.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotBlank(message = "Title must not be null")
    @Size(
            max = 100,
            message = "Title cannot be longer than 100 characters."
    )
    private String title;

    @NotBlank(message = "Author must not be null")
    @Size(
            max = 100,
            message = "Author cannot be longer than 100 characters."
    )
    private String author;

    @NotNull(message = "Publication date is required")
    private Long publicationYear;


    @NotBlank(message = "Genre must not be null")
    @Size(
            max = 50,
            message = "Genre cannot be longer than 50 characters."
    )
    private String genre;


    @NotBlank(message = "ISBN must not be null")
    @Size(
            max = 20,
            message = "ISBN cannot be longer than 20 characters."
    )
    private String isbn;
}
