package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class ContratImpl implements IContratService{

    ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat C) {
        return contratRepository.save(C);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat updateContrat(Contrat C) {
        return contratRepository.save(C);
    }

    @Override
    public Contrat retrieveContrat(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }
  


}
