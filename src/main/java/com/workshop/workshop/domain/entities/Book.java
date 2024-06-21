package com.workshop.workshop.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(20)")
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(columnDefinition = "INT(11)", name = "publication_year")
    private Long publicationYear;

    @Column(length = 50)
    private String genre;

    @Column(length = 20)
    private String isbn;

    @OneToMany(
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(
            mappedBy = "id",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Reservation> reservations = new ArrayList<>();
}
