package tn.esprit.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.TriunivDto;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
public class UniversitieImpl implements IUniversiteService{
@Autowired
    UniversiteRepository universiteRepository;
@Autowired

    DepartementRepository DepartementRepository;
    @Override
    public List<Universite> retrieveAllUniversite() {return (List<Universite>) universiteRepository.findAll();}

    @Override
    public Universite addUniversite(Universite Un) {return universiteRepository.save(Un);}

    @Override
    public void deleteUniversite(Integer id) {universiteRepository.deleteById(id);}

    @Override
    public Universite updateUniversite(Universite Un) {return universiteRepository.save(Un);}

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }
    
    @Override
    public void assignUniversiteToDepartement(Integer idUniv, Integer idDep) {
        Universite u=universiteRepository.findById(idUniv).orElse(null);
        Departement d= DepartementRepository.findById(idDep).orElse(null);
        u.getDepartements().add(d);
        universiteRepository.save(u);
    }
    
    @Override
    public Integer getUniversiteByDepartementNumber(Integer idUniv) {
    	List<Departement> dep = universiteRepository.getUniversiteByDepartementNumber(idUniv);
    	Integer ss = 0;
    	for (Departement dd : dep) {
    		dd.getIdDepart();
    		ss++;
		}
    	return ss;
    }
    @Override
    public int nbrEtudiantInUniv(Integer id) {
        return universiteRepository.nbretudUniv(id);
    }

    @Override
    public List<TriunivDto> triUnivParEtudiant() {
        return universiteRepository.triuniv();
    }
}
