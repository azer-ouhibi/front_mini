package tn.esprit.springproject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@FieldDefaults(level = AccessLevel.)
public class DetailEquipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idDetailEquipe;
    private Integer salle;
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;
}
