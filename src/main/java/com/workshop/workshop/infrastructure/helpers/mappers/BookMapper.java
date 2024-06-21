package com.workshop.workshop.infrastructure.helpers.mappers;

import com.workshop.workshop.api.dto.request.BookRequest;
import com.workshop.workshop.api.dto.response.BookAllResponse;
import com.workshop.workshop.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    Book toBook(BookRequest bookRequest);

    BookAllResponse toBookResponse(Book book);

    @Mapping(target = "id", ignore = true)

    void updateFromBookRequest(BookRequest bookRequest, @MappingTarget Book book);
}
