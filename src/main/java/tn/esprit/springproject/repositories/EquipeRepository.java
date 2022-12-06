package tn.esprit.springproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.springproject.entities.Equipe;

public interface EquipeRepository extends CrudRepository<Equipe,Integer> {
}
