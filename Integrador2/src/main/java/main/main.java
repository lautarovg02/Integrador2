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
import java.util.List;

public class main {
    public static void main(String[] args) {

        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();


        /**
         * Ejercicio 2 a
         *
         * Dar de alta un estudiante.
         * **/
        Student newStudent = new Student(33016244L, "Lionel", "Messi", "Alien", "Rosario", 36, 10);
        StudentRepository studentRepository = new StudentRepository(em);
        studentRepository.addStudent(newStudent);


        /**
         * Ejercicio 2 b
         *
         * Matricular un Estudiante en una Carrera.
         * **/

        // Creamos una carrera para matricular
        Career career = new Career(100, "TUDAI", 3);
        CareerRepository careerDAO = new CareerRepository(em);
        careerDAO.addCareer(career);


        // Agregamos la matricula
        Tuition tuition = new Tuition(career, newStudent, 2, 2021, 2023);
        TuitionRepository tuitionDAO = new TuitionRepository(em);
        tuitionDAO.addTution(tuition);

        /**
         * Ejercicio 2 c
         *
         * Recuperar todos los Estudiantes, y especificar algun criterio de ordenamiento simple.
         * **/
        List<Student> students = studentRepository.getStudentsInOrder();
        students.forEach(System.out::println);


        /**
         * Ejercicio 2 d
         *
         * Recuperar un Estudiante, en base a su numero de libreta universitaria
         * **/
        System.out.println("MESII PAPAAA: " + studentRepository.getStudentByUniN(10));

        em.close();

        emf.close();
    }
}
