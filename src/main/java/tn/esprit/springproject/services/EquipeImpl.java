package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.repositories.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeImpl implements IEquipeService{
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipe() {return (List<Equipe>) equipeRepository.findAll();}

    @Override
    public Equipe addEquipe(Equipe Eq) {return equipeRepository.save(Eq);}

    @Override
    public void deleteEquipe(Integer id) {equipeRepository.deleteById(id);}

    @Override
    public Equipe updateEquipe(Equipe Eq) {return equipeRepository.save(Eq);}

    @Override
    public Equipe retrieveEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }
}
