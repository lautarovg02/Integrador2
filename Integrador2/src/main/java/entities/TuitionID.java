package entities;

import javax.persistence.Entity;
import java.io.Serializable;

public class TuitionID implements Serializable {
    private Long DNI;
    private  Long idCareer;

    public TuitionID() {

    }
    public TuitionID(Long DNI, Long idCareer) {
        this.DNI = DNI;
        this.idCareer = idCareer;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public Long getIdCareer() {
        return idCareer;
    }

    @Override
    public String toString() {
        return "TuitionID{" +
                "DNI=" + DNI +
                ", idCareer=" + idCareer +
                '}';
    }

    public void setIdCareer(Long idCareer) {
        this.idCareer = idCareer;
    }
}
