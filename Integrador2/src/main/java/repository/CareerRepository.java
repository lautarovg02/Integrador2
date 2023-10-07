package repository;

import dto.CareerDTO;
import entities.Career;
import entities.Tuition;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


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

    public List<Career> getCareers() {
        em.getTransaction().begin();
        String jpql = Career.SEARCH_ALL_CAREERS;
        Query query = em.createNamedQuery(jpql);
        List<Career> careers = query.getResultList();
        em.getTransaction().commit();
        return careers;
    }

}
