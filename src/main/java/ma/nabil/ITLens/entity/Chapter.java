package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @ManyToOne(optional = false)
    @NotNull(message = "Survey is mandatory")
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    private List<SubChapter> subChapters = new ArrayList<>();
}