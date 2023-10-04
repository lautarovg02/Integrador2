package entities;

import javax.persistence.Entity;
import java.io.Serializable;


public class TuitionID implements Serializable {
    private int DNI;
    private  int idCareer;

    public TuitionID() {
    }

    public TuitionID(int DNI, int idCareer) {
        this.DNI = DNI;
        this.idCareer = idCareer;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }
}
