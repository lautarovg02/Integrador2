package main;

import dao.CareerDAO;
import dao.StudentDAO;
import entities.Student;
import factory.MyFactoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Select {
    public static void main(String[] args) {

        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();

        //GET CAREERS
        CareerDAO cDao = new CareerDAO(em);
        System.out.println(cDao.getCareers());


        StudentDAO studentDAO = new StudentDAO(em);
        List<Student> students = studentDAO.getStudentsInOrder();

        students.forEach(System.out::println);

//        em.getTransaction().commit();
//        em.close();
        em.close();
        emf.close();
    }


}
