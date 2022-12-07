package tn.esprit.springproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.TriunivDto;
import tn.esprit.springproject.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
	
	@Query(" select u.departements from Universite u where u.id=:id")
	List<Departement> getUniversiteByDepartementNumber(@Param("id") Integer id);

	///////////////////////////////////////////////////////////////////////////////////////////

    @Query(value = "SELECT COUNT(etudiant.id_etudiant) FROM etudiant\n" +
            "LEFT JOIN departement ON departement.id_depart=etudiant.departement_id_depart \n" +
            "LEFT JOIN universite ON universite.id = universite.departements.universite_id\n" +
            "WHERE universite.id= :id", nativeQuery = true)
    public int nbretudUniv(@Param("id") Integer id);

    ///////////////////////////////////////////////////////////////////////////////////////////

    @Query(value = "SELECT    universite.nom_univ univ, COUNT(etudiant.id_etudiant)  nbr FROM etudiant\n" +
            "            LEFT JOIN departement ON departement.id_depart=etudiant.departement_id_depart\n" +
            "            LEFT JOIN universite ON universite.id = departement.universite_id\n" +
            "            GROUP BY(universite.id)\n" +
            "            ORDER BY(COUNT(etudiant.id_etudiant) ) DESC;", nativeQuery = true)
    public List<TriunivDto> triuniv();
}
