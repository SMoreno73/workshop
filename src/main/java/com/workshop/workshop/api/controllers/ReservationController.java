package com.workshop.workshop.api.controllers;

import com.workshop.workshop.api.dto.request.ReservationRequest;
import com.workshop.workshop.api.dto.response.ReservationAllResponse;
import com.workshop.workshop.infrastructure.abstract_services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
    @Autowired
    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationAllResponse> saveReservation(@Validated @RequestBody ReservationRequest reservationRequest) {
        return ResponseEntity.ok(reservationService.create(reservationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationAllResponse> updateReservation(
            @PathVariable Long id,
            @Validated @RequestBody ReservationRequest reservationRequest
    ) {
        return ResponseEntity.ok(reservationService.update(id, reservationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ReservationAllResponse>> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ReservationAllResponse>> getAllReservations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(reservationService.getAll(pageable));
    }
}
