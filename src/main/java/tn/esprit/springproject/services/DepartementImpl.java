package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.repositories.DepartementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementImpl implements IDepartementService{

    DepartementRepository departementRepository;
    @Override
    public List<Departement> retrieveAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public void deleteDepartement(Integer id) {departementRepository.deleteById(id);}

    @Override
    public Departement updateDepartement(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public Departement retrieveDepartement(Integer id) {
    	return departementRepository.findById(id).orElse(null);
    }
    @Override
    public List<Departement> listAll(String keyword) {
        if (keyword != null) {
            return departementRepository.search(keyword);
        }
        return departementRepository.findAll();
    }
}
