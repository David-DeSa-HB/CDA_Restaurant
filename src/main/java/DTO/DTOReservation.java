package DTO;


import com.trois.restaurant.entity.Commande;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOReservation {

    private Long commandeId;

    @NotBlank(message = "Please, give a proper name")
    @Size(message = "The name must have at least 5 characters", min = 5)
    private String nom;

    private Date date;

    private int nbPersonne;

}
