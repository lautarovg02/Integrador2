package dao;

import entities.Career;
import entities.Student;
import entities.Tuition;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CareerDAO {
    EntityManager em;

    public CareerDAO(EntityManager em) {
        this.em = em;
    }

    public void addCareer(Career career) {
        em.getTransaction().begin();
        Career exist = em.find(Career.class, career.getIdCareer());
        if (career != null && exist == null) {
            em.persist(career);
        }
        em.getTransaction().commit();
    }
}
