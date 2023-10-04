package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Tuition {

    @EmbeddedId
    private TuitionID id= new TuitionID();

    @ManyToOne
    @JoinColumn(name = "fk_id_career")
    private Career career;

    @ManyToOne
    @JoinColumn(name = "fk_DNI")
    private Student student;

    @Column
    private int antiquity;

    @Column
    private boolean graduate;

    public Tuition(TuitionID id, int antiquity, boolean graduate) {
        this.id = id;
        this.antiquity = antiquity;
        this.graduate = graduate;
    }

    public Tuition() {

    }

    public Tuition(TuitionID id, int antiquity, Student s, Career c, boolean graduate) {
        this.id = id;
        this.antiquity = antiquity;
        this.graduate = graduate;
        this.student = s;
        this.career = c;

    }

    @Override
    public String toString() {
        return "Tuition{" +
                "id=" + id +
                ", antiquity=" + antiquity +
                ", graduate=" + graduate +
                '}';
    }
}
