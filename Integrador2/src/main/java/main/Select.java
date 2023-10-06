package main;

import dao.CareerDAO;
import factory.MyFactoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Select {
    public static void main(String[] args) {

        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();

        //GET CAREERS
        CareerDAO cDao = new CareerDAO(em);
        System.out.println(cDao.getCareers());



//        em.getTransaction().commit();
//        em.close();
        emf.close();
    }


}
