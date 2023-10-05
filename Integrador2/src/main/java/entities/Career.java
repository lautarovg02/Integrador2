package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Career {


    @Id
    @Column(name = "id_career")
    private long idCareer;

    @Column(name = "name_career")
    private String name;

    @Column
    private  int duration;

    @OneToMany(mappedBy = "student")
    private List<Tuition> tuitons;

    public Career() {
    }

    public Career(long idCareer, String name, int duration) {
        this.idCareer = idCareer;
        this.name = name;
        this.duration = duration;
        this.tuitons = new ArrayList<>();
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

    public List<Tuition> getTuitons() {
        return tuitons;
    }

    public void setTuitons(List<Tuition> tuitons) {
        this.tuitons = tuitons;
    }

    @Override
    public String toString() {
        return "Career{" +
                "idCareer=" + idCareer +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
