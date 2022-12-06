package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Etudiant;

public interface IEtudiantService {
    Iterable<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant (Etudiant Et);

    void removeEtudiant(Integer idEtudiant);

    Etudiant updateEtudiant (Etudiant Et);

    Etudiant retrieveEtudiant(Integer id);
    
    void deleteEtudiant(Integer id);
}
