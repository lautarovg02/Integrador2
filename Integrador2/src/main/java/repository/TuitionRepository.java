package repository;

import dto.CareerDTO;
import entities.Career;
import entities.Student;
import entities.Tuition;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TuitionRepository {

    EntityManager em;

    public TuitionRepository(EntityManager em) {
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
            List<Tuition> tuitionExist = query.getResultList();
            System.out.println(tuitionExist);
            if (tuitionExist.isEmpty()) {

                Career c = tuition.getCareer();
                c.addTuitions(tuition);
                em.persist(tuition);
                em.merge(c);

            } else {
                System.out.println("ERROR: Ya existe la Matricula" + "\n");
            }

            em.getTransaction().commit();
        } else {
            System.out.println("ERROR: La matricula no existe" + "\n");
        }

    }


    public List<Tuition> getCareerWithStudentsEnrolled() {
        List<Tuition> tuitions ;

        em.getTransaction().begin();

        String jpql = "SELECT new dto.CareerDTO(t.career.idCareer, t.career.name, count(t.career))" +
                "  FROM Tuition t GROUP BY t.career ORDER BY COUNT(t.career) DESC";

        Query query = em.createQuery(jpql);
        tuitions= query.getResultList();

        em.getTransaction().commit();
        return tuitions;
    }
}
