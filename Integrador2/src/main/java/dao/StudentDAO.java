package dao;

import entities.Career;
import entities.Student;
import factory.MyFactoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    EntityManager em;

    public StudentDAO(EntityManager em) {
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
