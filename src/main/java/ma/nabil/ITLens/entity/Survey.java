package ma.nabil.ITLens.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Survey {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    
    @OneToMany(mappedBy = "survey")
    private List<SurveyEdition> editions;

    @ManyToOne
    private Owner owner;

}
