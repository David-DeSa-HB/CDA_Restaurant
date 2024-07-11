package com.trois.restaurant.controller_api;

import com.trois.restaurant.entity.Plat;
import com.trois.restaurant.service.PlatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/plat")
public class PlatRestController {

    private final PlatService platService;

    @GetMapping
    public List<Plat> getAllPlats(){
        return platService.findAll();
    }

    @PostMapping
    public Plat savePlat(@RequestBody Plat plat){
        if(plat.getId() != null){
            return platService.savePlat(plat);
        }
        return platService.updatePlat(plat, plat.getId());
    }

}