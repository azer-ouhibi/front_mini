package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.repositories.ContratRepository;

import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrat();

    Contrat addContrat(Contrat C);

    void deleteContrat (Integer id);

    Contrat updateContrat(Contrat C);

    Contrat retrieveContrat(Integer id);
   

}
