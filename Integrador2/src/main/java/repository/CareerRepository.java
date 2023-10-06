package repository;

import entities.Career;

import javax.persistence.EntityManager;

public class CareerRepository {
    EntityManager em;

    public CareerRepository(EntityManager em) {
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
