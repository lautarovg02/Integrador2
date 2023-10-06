package repository;

import entities.Career;
import entities.Student;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
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

    public Student getStudentByUniN(int num){
        em.getTransaction().begin();
        String jpql = "SELECT s FROM Student s WHERE s.uniNumber = :LU";
        Query query = em.createQuery(jpql);
        query.setParameter("LU", num);
        List<Student> resultList = query.getResultList();
        em.getTransaction().commit();
        if(resultList.isEmpty()){
            System.out.println("ERROR: No encontro un resultado");
            return null;
        }else{
            return resultList.get(0);
        }
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
