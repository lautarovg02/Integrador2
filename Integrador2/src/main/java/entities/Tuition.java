package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Tuition {

    @EmbeddedId
    private TuitionID id= new TuitionID();

    @ManyToOne
    @MapsId("idCareer")
    @JoinColumn(name = "fk_id_career")
    private Career career;

    @ManyToOne
    @MapsId("DNI")
    @JoinColumn(name = "fk_DNI")
    private Student student;


    @Column
    private Timestamp antiquity;

    @Column
    private boolean graduate;



}
