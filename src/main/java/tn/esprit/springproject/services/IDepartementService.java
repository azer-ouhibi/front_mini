package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartement();

    Departement addDepartement(Departement D);

    void deleteDepartement(Integer id);

    Departement updateDepartement(Departement D);

    Departement retrieveDepartement(Integer id);
    
    List<Departement> listAll(String keyword);
}
