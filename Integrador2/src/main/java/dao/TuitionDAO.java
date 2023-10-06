package dao;

import entities.Career;
import entities.Student;
import entities.Tuition;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TuitionDAO {

    EntityManager em;

    public TuitionDAO(EntityManager em) {
        this.em = em;
    }

    public void addTution(Tuition tuition) {
        if (tuition != null && tuition.getStudent() != null && tuition.getCareer() != null) {
            em.getTransaction().begin();
            Career existC = em.find(Career.class, tuition.getCareer().getIdCareer());
            Student existS = em.find(Student.class, tuition.getStudent().getDNI());
//        Tuition exist = em.find(Tuition.class, tuition.getId());

            String jpql = "SELECT t FROM Tuition t WHERE t.student = :DNI AND t.career = :id_career";
            Query query = em.createQuery(jpql);
            query.setParameter("DNI", existS);
            query.setParameter("id_career", existC);
            Tuition tuitionExist = (Tuition) query.getResultList().get(0);
            if (tuitionExist == null) {
                em.persist(tuition);
            } else {
                System.out.println("ERROR: Ya existe la Matricula" + "\n");
            }
            em.getTransaction().commit();
        } else {
            System.out.println("ERROR: La matricula no existe" + "\n");
        }
    }


}
