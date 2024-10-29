package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Integer answerCount;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    // Getters and setters
}