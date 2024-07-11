package com.trois.restaurant.service;

import com.trois.restaurant.entity.Plat;
import com.trois.restaurant.repository.PlatRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatService {

    private final PlatRepository platRepository;

    public List<Plat> findAll() {
        return platRepository.findAll();
    }

    public Plat findById(Long id){
        return platRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Plat savePlat(Plat plat) {
        return platRepository.saveAndFlush(plat);
    }

    public Plat updatePlat(Plat plat, Long id){
        plat.setId(id);
        return platRepository.saveAndFlush(plat);
    }
}