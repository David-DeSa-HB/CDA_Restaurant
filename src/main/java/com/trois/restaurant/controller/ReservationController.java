package com.trois.restaurant.controller;

import DTO.DTOReservation;
import com.trois.restaurant.entity.Reservation;
import com.trois.restaurant.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @GetMapping("")
    public List <Reservation> index () {
        return reservationService.findAll();
    }

    @PostMapping("")
    public Reservation create(@RequestBody DTOReservation reservation) {
        return reservationService.create(reservation);
    }
}
