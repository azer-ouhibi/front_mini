package tn.esprit.springproject.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.services.IContratService;
@RestController
@RequestMapping
@AllArgsConstructor
public class ContratController {
    IContratService contratService;

    Contrat addContrat(Contrat C){
        return contratService.addContrat(C);
    }
}
