package com.workshop.workshop.api.dto.response.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;

    private String title;

    private String author;

    private Long publicationYear;

    private String genre;

    private String isbn;


}
