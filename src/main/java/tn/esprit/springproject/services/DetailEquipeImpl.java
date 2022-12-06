package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.repositories.DetailEquipeRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class DetailEquipeImpl implements IDetailEquipeService{

    DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipe() {return (List<DetailEquipe>) detailEquipeRepository.findAll();}

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe De) {
        return detailEquipeRepository.save(De);
    }

    @Override
    public void deleteDetailEquipe(Integer id) { detailEquipeRepository.deleteById(id);}

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe De) {
        return detailEquipeRepository.save(De);
    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }
}
