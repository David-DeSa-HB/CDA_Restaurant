package com.trois.restaurant.service;

import com.trois.restaurant.DTO.MenuDTO;
import com.trois.restaurant.entity.Menu;
import com.trois.restaurant.entity.Plat;
import com.trois.restaurant.repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final PlatService platService;

    public Menu create(MenuDTO menuDTO){
        Menu menu = new Menu();
        List<Plat> plats = new ArrayList<>();
        for(int i = 0 ; i < menuDTO.getPlats().size() ; i++){
            Plat plat = platService.findById(menuDTO.getPlats().get(i));
            plats.add(plat);
        }
        menu.setPlats(plats);
        menu.setNom(menuDTO.getNom());
        return menuRepository.saveAndFlush(menu);
    }

    public Menu addOrRemovePlat(Plat plat, Long id){
        Menu menu = menuRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        List<Plat> plats = menu.getPlats();
        if(plats.contains(plat)){
            System.out.println("Insertion");
            plats.remove(plat);
        } else {
            System.out.println("Suppression");
            plats.add(plat);
        }
        menu.setPlats(plats);
        return menuRepository.saveAndFlush(menu);
    }

}