package com.workshop.workshop.infrastructure.abstract_services;

import com.workshop.workshop.api.dto.request.ReservationRequest;
import com.workshop.workshop.api.dto.response.ReservationAllResponse;
import com.workshop.workshop.domain.entities.Reservation;

public interface IReservationService extends CRUDService<ReservationRequest, ReservationAllResponse, Long> {
    Reservation getReservationById(Long id);
}
