package com.workshop.workshop.infrastructure.helpers.mappers;

import com.workshop.workshop.api.dto.request.ReservationRequest;
import com.workshop.workshop.api.dto.response.ReservationAllResponse;
import com.workshop.workshop.domain.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bookId.id", source = "bookId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    Reservation toReservation(ReservationRequest reservationRequest);

    ReservationAllResponse toReservationResponse(Reservation reservation);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bookId.id", source = "bookId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    void updateFromReservationRequest(ReservationRequest reservationRequest, @MappingTarget Reservation reservation);
}
