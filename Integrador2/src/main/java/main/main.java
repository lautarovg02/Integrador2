package main;

import entities.Tuition;
import repository.CareerRepository;
import factory.MyFactoryEntityManager;
import repository.TuitionRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class main {
    public static void main(String[] args) {

        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();


        //CARGAMOS LOS CSV
        //Insert.cargarCSV(em);

        /**
         * Ejercicio 2 a
         *
         * Dar de alta un estudiante.
         * **/
       /* Student newStudent = new Student(33016244L, "Lionel", "Messi", "Alien", "Rosario", 36, 10);
        StudentRepository studentRepository = new StudentRepository(em);
        studentRepository.addStudent(newStudent);


        /**
         * Ejercicio 2 b
         *
         * Matricular un Estudiante en una Carrera.
         * **/

       /* // Creamos una carrera para matricular
        Career career = new Career(100, "TUDAI", 3);
        CareerRepository careerRepository = new CareerRepository(em);
        careerRepository.addCareer(career);


        // Agregamos la matricula
        Tuition tuition = new Tuition(career, newStudent, 2, 2021, 2023);
        TuitionRepository tuitionDAO = new TuitionRepository(em);
        tuitionDAO.addTution(tuition);

        /**
         * Ejercicio 2 c
         *
         * Recuperar todos los Estudiantes, y especificar algun criterio de ordenamiento simple.
         * **/
        /*List<Student> students = studentRepository.getStudentsInOrder();
        students.forEach(System.out::println);


        /**
         * Ejercicio 2 d
         *
         * Recuperar un Estudiante, en base a su numero de libreta universitaria
         * **/
      /*  System.out.println("MESII PAPAAA: " + studentRepository.getStudentByUniN(10));


        /**
         * Ejercicio 2 e
         *
         * Recuperar todos los Estudiantes, en base a su Genero
         * **/
//        System.out.println("Estudiantes por genero Alien " + studentRepository.getStudentsByGenre("Alien"));



        // Ejercicio 2 f
        /**
         * recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
         */


        TuitionRepository tuitionRepository = new TuitionRepository(em);
        List<Tuition> tuitions =  tuitionRepository.getCareerWithStudentsEnrolled();
        System.out.println(tuitions);

        // Ejercicio 2 g
        /**
         *  recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
         */

        em.close();

        emf.close();
    }
}
