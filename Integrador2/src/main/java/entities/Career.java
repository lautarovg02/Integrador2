package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = Career.SEARCH_ALL_CAREERS, query = "SELECT c FROM Career c")
public class Career {

    public static final String SEARCH_ALL_CAREERS = "Career.SEARCH_ALL_CAREERS" ;
    @Id
    @Column(name = "id_career")
    private long idCareer;

    @Column(name = "name_career")
    private String name;

    @Column
    private int duration;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Tuition> tuitions;

    public Career() {
    }

    public Career(long idCareer, String name, int duration) {
        this.idCareer = idCareer;
        this.name = name;
        this.duration = duration;
        this.tuitions = new ArrayList<>();
    }

    public long getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(long idCareer) {
        this.idCareer = idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Tuition> getTuitions() {
        return tuitions;
    }

    public void setTuitions(List<Tuition> tuitions) {
        this.tuitions = tuitions;
    }
    public void addTuitions(Tuition tuition) {
        this.tuitions.add(tuition);
    }

    @Override
    public String toString() {
        return "Career{" +
                "idCareer=" + idCareer +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ",tuitions=" + tuitions +
                '}' + "\n";
    }
}
