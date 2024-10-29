package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Text is mandatory")
    private String text;

    private Integer answerCount;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
}