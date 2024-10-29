package ma.nabil.ITLens.entity;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Integer selectionCount;

    @ManyToOne
    private Question question;
}