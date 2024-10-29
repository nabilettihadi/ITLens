package ma.nabil.ITLens.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class SurveyEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date creationDate;
    private Date startDate;
    private Integer year;

    @ManyToOne
    private Survey survey;

}
