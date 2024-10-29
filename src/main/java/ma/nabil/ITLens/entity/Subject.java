package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToMany(mappedBy = "subject")
    private List<Question> questions;

    @ManyToOne
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject")
    private List<Subject> subSubjects;

}