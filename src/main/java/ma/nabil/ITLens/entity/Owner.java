package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Survey> surveys;
}