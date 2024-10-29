package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    @OneToMany(mappedBy = "survey")
    private List<SurveyEdition> editions;

    @ManyToOne
    private Owner owner;
}