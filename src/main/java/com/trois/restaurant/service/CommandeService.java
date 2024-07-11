package com.trois.restaurant.service;

import com.trois.restaurant.DTO.CommandeDTO;
import com.trois.restaurant.entity.Commande;
import com.trois.restaurant.entity.Plat;
import com.trois.restaurant.repository.CommandeRepository;
import jakarta.activation.CommandObject;
import lombok.AllArgsConstructor;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommandeService {
        private CommandeRepository commandeRepository;
        private PlatService platService;

        public List<Commande> findAll() {return this.commandeRepository.findAll();}
        public Commande findById(Long id) {return this.commandeRepository.findById(id).orElse(null);}

        public Commande createCommande(CommandeDTO plats) {
               Commande commande = new Commande();

               for (Long plat : plats.getPlat()) {
                      commande.addPlat(platService.findById(plat));
               }
               commande.setStatus("En cours");

               return commandeRepository.saveAndFlush(commande);
        }

        public Commande updateCommande(CommandeDTO plats) {
            Commande commande = commandeRepository.findById(plats.getCommandId()).orElse(null);
            commande.setStatus("Terminée");
            return commandeRepository.saveAndFlush(commande);

        }

}
