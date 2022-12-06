package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipe();

    Equipe addEquipe(Equipe Eq);

    void deleteEquipe(Integer id);

    Equipe updateEquipe(Equipe Eq);

    Equipe retrieveEquipe(Integer id);
}
