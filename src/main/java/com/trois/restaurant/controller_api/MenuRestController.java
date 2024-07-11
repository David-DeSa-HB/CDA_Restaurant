package com.trois.restaurant.controller_api;

import com.trois.restaurant.DTO.MenuDTO;
import com.trois.restaurant.entity.Menu;
import com.trois.restaurant.entity.Plat;
import com.trois.restaurant.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/menu")
public class MenuRestController {

    private final MenuService menuService;

    @PostMapping
    public Menu create(@RequestBody MenuDTO menuDTO){
        return menuService.create(menuDTO);
    }

    @PutMapping
    public Menu addOrRemovePlat(@RequestBody Long platId, Long id){
        return menuService.addOrRemovePlat(platId,id);
    }

}