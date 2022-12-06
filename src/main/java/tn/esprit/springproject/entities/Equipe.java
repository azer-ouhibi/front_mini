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
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    private Long idEquipe; //clé primaire
    private String nomEquipe;
    @Enumerated (EnumType.STRING)
    private Niveau niveau;
    @OneToOne(cascade = CascadeType.ALL)
    DetailEquipe detailEquipe;
    @ManyToMany
    private Set<Etudiant>etudiants;


}
