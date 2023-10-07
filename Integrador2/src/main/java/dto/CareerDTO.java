package dto;

import entities.Tuition;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class CareerDTO {
    private long idCareer;

    private String name;
    private long cantEnrolled;

    public CareerDTO(long idCareer, String name, long cantEnrolled) {
        this.idCareer = idCareer;
        this.name = name;
        this.cantEnrolled = cantEnrolled;
    }

    public CareerDTO() {

    }

    public CareerDTO(long idCareer, String name) {
        this.idCareer = idCareer;
        this.name = name;
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

    public long getCantEnrolled() {
        return cantEnrolled;
    }

    public void setCantEnrolled(long cantEnrolled) {
        this.cantEnrolled = cantEnrolled;
    }

    @Override
    public String toString() {
        return "CareerDTO{" +
                "idCareer=" + idCareer +
                ", name='" + name + '\'' +
                ", cantEnrolled=" + cantEnrolled +
                "} \n";
    }
}
