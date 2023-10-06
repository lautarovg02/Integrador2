package main;

import repository.CareerRepository;
import repository.StudentRepository;
import repository.TuitionRepository;
import entities.Career;
import entities.Student;
import entities.Tuition;
import factory.MyFactoryEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class main {
    public static void main(String[] args) {

        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();
        // Ejercicio 2 a
        Student newStudent = new Student(33016244L,"Lionel","Messi","Alien", "Rosario", 36,10);

        StudentRepository studentDAO = new StudentRepository(em);

        studentDAO.addStudent(newStudent);


        // Ejercicio 2 b
        // add carrera
        Career career = new Career(100,"TUDAI",3);
        CareerRepository careerDAO = new CareerRepository(em);
        careerDAO.addCareer(career);


        // add tuiton
        Tuition tuition = new Tuition(career,newStudent,2,2021,2023);
        TuitionRepository tuitionDAO = new TuitionRepository(em);
        tuitionDAO.addTution(tuition);


        //  Ejercicio 2 c

        em.close();

        emf.close();


    }
}
