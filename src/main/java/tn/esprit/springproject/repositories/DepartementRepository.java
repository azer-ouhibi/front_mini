package tn.esprit.springproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.springproject.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {

	@Query("SELECT d FROM Departement d WHERE d.nomDepart LIKE %?1%")
	public List<Departement> search(String keyword);
}
