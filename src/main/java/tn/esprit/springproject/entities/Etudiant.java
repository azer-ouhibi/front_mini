package tn.esprit.springproject.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option op;

    @OneToMany(mappedBy="etudiant")
    private Set<Contrat> contrats;
    @ManyToOne
    Departement departement;
    @ManyToMany(mappedBy = "etudiants")
    private Set<Equipe> equipes;


}
