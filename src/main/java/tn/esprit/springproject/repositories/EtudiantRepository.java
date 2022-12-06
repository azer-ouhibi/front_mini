package tn.esprit.springproject.repositories;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.services.EtudiantImpl;

import java.util.List;

public interface EtudiantRepository extends CrudRepository<Etudiant,Integer> {

    //@Query(value = "select * from T_Etudiant where prenom=?2 and nom=?1", nativeQuery = true)
    //List<Etudiant> selectByNometPrenomSQL (String nom, String prenom);

    //@Query(value = "select * from T_Etudiant where prenom=:prenom and nom=:nom", nativeQuery = true)
   // List<Etudiant> selectByNometPrenomSQL2 (@Param("nom") String nom, @Param("prenom") String Prenom);

    //afficher la liste des etudiants
    //@Query (value = "select * from T_Etudiant e join contrat c on c.etudiant_id = e.id where c.archive=:a", nativeQuery = true)
    //List<Etudiant> selectEtudiantContratSQL(@Param("a") boolean archive);
    
    //@Query ("select etudiant from Etudiant etudiant,Contrat contrat where contrat.etudiant.idEtudiant=etudiant.idEtudiant" and contrat.archive=?1) //JPQL
    //List<Etudiant> selectEtudiantContratJPQL(Boolean archive);

  //  @Modifying
    //@Query("update  Etudiant set prenomE=?1 where nomE='ferchichi')
    //Etudiant update (String prenom);

    //afficher la lste des etudiants du departement iformatique d l'université esprit
    //List<Etudiant> select(String depart,String universite);


   // @Query("select e from Etudiant e " +
     //       "JOIN Departement d on e.departement.idDepart=d.idDepart" +
       //     " JOIN Universite u on d.idDepart" )
 //   List<Etudiant> select(String departement, String universite);
}
