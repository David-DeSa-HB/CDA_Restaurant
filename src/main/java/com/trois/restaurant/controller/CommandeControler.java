package com.trois.restaurant.controller;

import com.trois.restaurant.DTO.CommandeDTO;
import com.trois.restaurant.entity.Commande;
import com.trois.restaurant.service.CommandeService;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.ICommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/commande")
public class CommandeControler {

    private CommandeService commandeService;

    @GetMapping
    public List<Commande> index() {
        return commandeService.findAll();
    }

    @PostMapping
    public Commande create(@RequestBody CommandeDTO commande) {
        return commandeService.createCommande(commande);
    }

    @PutMapping
    public Commande update(@RequestBody CommandeDTO commande) {
        return commandeService.updateCommande(commande);
    }

}
