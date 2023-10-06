package dao;

import entities.Student;
import factory.MyFactoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
}
