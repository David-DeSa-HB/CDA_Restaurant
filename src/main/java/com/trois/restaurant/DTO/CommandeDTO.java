package com.trois.restaurant.DTO;

import com.trois.restaurant.entity.Plat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDTO {
    private List<Long> plat;

    private Long commandId;
}
