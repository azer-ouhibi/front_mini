package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.EquipeRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service

public class EtudiantImpl implements IEtudiantService{
    EtudiantRepository etudiantRepository;
    DepartementRepository DepartementRepository;
    ContratRepository  ContratRepository;
    EquipeRepository EquipeRepository;
    
    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        List<Etudiant> Etudiants=(List<Etudiant>) etudiantRepository.findAll();
        for(Etudiant e:Etudiants) {
            //System.out.println(e);
        }
        return Etudiants;}

    @Override
    public Etudiant addEtudiant(Etudiant Et) {
        return etudiantRepository.save(Et);
        }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);}

    @Override
    public Etudiant updateEtudiant(Etudiant Et) {return etudiantRepository.save(Et);}

    @Override
    public Etudiant retrieveEtudiant(Integer id) {
        return etudiantRepository.findById(id).orElse(null);}
   
    
    @Override
    public void removeEtudiant(Integer idEtudiant) {


            boolean exists =etudiantRepository.existsById(idEtudiant);
            if(!exists) {

                throw new IllegalStateException (
                        "Etudiant with id" +idEtudiant + "does not exists");
            }

            etudiantRepository.deleteById(idEtudiant);

        }

   
 
}
