package repository;

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    EntityManager em;

    public StudentRepository(EntityManager em) {
        this.em = em;
    }

    public void addStudent(Student student) {
        em.getTransaction().begin();
        Student exist = em.find(Student.class, student.getDNI());
        if (student != null && exist == null) {
            em.persist(student);
        }
        em.getTransaction().commit();

    }

    public List<Student> getStudentsInOrder() {
        List<Student> students = new ArrayList<>();
        em.getTransaction().begin();

        String jpql = Student.SEARCH_ALL;
        Query query = em.createNamedQuery(jpql);
        students = (List<Student>) query.getResultList();
        em.getTransaction().commit();
        return students;
    }
}
