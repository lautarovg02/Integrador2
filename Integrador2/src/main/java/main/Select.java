package main;

import repository.StudentRepository;
import entities.Student;
import factory.MyFactoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Select {
    public static void main(String[] args) {

        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();

        StudentRepository studentDAO = new StudentRepository(em);
        List<Student> students = studentDAO.getStudentsInOrder();

        students.forEach(System.out::println);

        em.close();
        emf.close();
    }


}
