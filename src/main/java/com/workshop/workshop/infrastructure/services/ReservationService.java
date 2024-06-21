package com.workshop.workshop.infrastructure.services;

import com.workshop.workshop.api.dto.request.ReservationRequest;
import com.workshop.workshop.api.dto.response.ReservationAllResponse;
import com.workshop.workshop.domain.entities.Book;
import com.workshop.workshop.domain.entities.Reservation;
import com.workshop.workshop.domain.entities.User;
import com.workshop.workshop.domain.repositories.ReservationRepository;
import com.workshop.workshop.infrastructure.abstract_services.IBookService;
import com.workshop.workshop.infrastructure.abstract_services.IReservationService;
import com.workshop.workshop.infrastructure.abstract_services.IUserService;
import com.workshop.workshop.infrastructure.helpers.mappers.ReservationMapper;
import com.workshop.workshop.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final ReservationMapper reservationMapper;

    @Autowired
    private final IUserService userService;

    @Autowired
    private final IBookService bookService;

    @Override
    public ReservationAllResponse create(ReservationRequest reservationRequest) {
        Reservation reservation = reservationMapper.toReservation(reservationRequest);

        User existingUser = userService.getUserById(reservationRequest.getUserId());
        Book existingBook = bookService.getBookById(reservationRequest.getBookId());

        reservation.setUserId(existingUser);
        reservation.setBookId(existingBook);

        return reservationMapper.toReservationResponse(reservationRepository.save(reservation));
    }

    @Override
    public ReservationAllResponse update(Long id, ReservationRequest reservationRequest) {
        Reservation existingReservation = getReservationById(id);
        User existingUser = userService.getUserById(reservationRequest.getUserId());
        Book existingBook = bookService.getBookById(reservationRequest.getBookId());

        existingReservation.setUserId(existingUser);
        existingReservation.setBookId(existingBook);

        return reservationMapper.toReservationResponse(reservationRepository.save(existingReservation));
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Page<ReservationAllResponse> getAll(Pageable pageable) {
        Page<Reservation> reservationPage = reservationRepository.findAll(pageable);
        return reservationPage.map(reservationMapper::toReservationResponse);
    }

    @Override
    public Optional<ReservationAllResponse> getById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) throw new IdNotFoundException("QUESTION", id);
        return reservation.map(reservationMapper::toReservationResponse);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("LOAN", id));
    }
}
