package com.trois.restaurant.service;


import DTO.DTOReservation;
import com.trois.restaurant.entity.Reservation;
import com.trois.restaurant.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements DAOServiceInterface<Reservation> {

    private ReservationRepository reservationRepository;
    //private CommandeService commandeService;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getObjectById(Long id) {
        return null;
    }

    @Override
    public Reservation findBySlug(String slug) {
        return null;
    }

    public Reservation create(DTOReservation reservationDto) {
        Reservation reservation = new Reservation();

        //reservation.setCommande(commandeService.findById(reservationDto.getCommandeId()));
        reservation.setNom(reservationDto.getNom());
        reservation.setNbPersonne(reservationDto.getNbPersonne());
        reservation.setDate(reservationDto.getDate());

        return reservationRepository.saveAndFlush(reservation);
    }


}
