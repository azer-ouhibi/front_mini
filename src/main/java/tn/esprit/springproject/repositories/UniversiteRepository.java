package tn.esprit.springproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
	
	@Query(" select u.departements from Universite u where u.idUniv=:id")
	List<Departement> getUniversiteByDepartementNumber(@Param("id") Integer id);
}
