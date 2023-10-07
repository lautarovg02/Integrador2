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

        Student ifExist = em.find(Student.class, student.getDNI());
        if (student != null && ifExist == null) {
            em.persist(student);
        }

        em.getTransaction().commit();

    }

    public Student getStudentByUniN(int num) {

        em.getTransaction().begin();

        String jpql = "SELECT s FROM Student s WHERE s.uniNumber = :LU";
        Query query = em.createQuery(jpql);
        query.setParameter("LU", num);
        List<Student> resultList = query.getResultList();

        em.getTransaction().commit();

        if (resultList.isEmpty()) {
            System.out.println("ERROR: No encontro un resultado");
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public List<Student> getStudentsInOrder() {
        List<Student> students;

        em.getTransaction().begin();

        String jpql = Student.SEARCH_ALL;
        Query query = em.createNamedQuery(jpql);
        students = (List<Student>) query.getResultList();

        em.getTransaction().commit();

        return students;
    }

    public List<Student> getStudentsByGenre(String genre) {
        List<Student> students;

        em.getTransaction().begin();

        String jpql = "SELECT s FROM Student s WHERE s.genre = :genre";
        Query query = em.createQuery(jpql);
        query.setParameter("genre", genre);

        students = (List<Student>) query.getResultList();

        em.getTransaction().commit();

        return students;
    }


}
