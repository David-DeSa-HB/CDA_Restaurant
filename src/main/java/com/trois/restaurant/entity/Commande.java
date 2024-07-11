package com.trois.restaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Plat> plats = new ArrayList<>();

    private String status;

    private LocalDate date;

    public void addPlat(Plat plat) {
        this.plats.add(plat);
    }

    public void updateCommande(String status) {
        this.status = status;
    }

}