package com.trois.restaurant.repository;

import com.trois.restaurant.entity.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatRepository extends JpaRepository<Plat, Long> {

    Optional<Plat> findById(Long id);

    Optional<Plat> findByNom(String nom);
}