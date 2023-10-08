package main;

import dto.CareerDTO;
import dto.ReportDTO;
import dto.StudentDTO;
import entities.Career;
import entities.Student;
import entities.Tuition;
import factory.EntityFactory;
import jdk.swing.interop.SwingInterOpUtils;
import repository.CareerRepository;
import factory.MyFactoryEntityManager;
import repository.StudentRepository;
import repository.TuitionRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class main {
    public static void main(String[] args) {

        EntityManagerFactory emf = EntityFactory.getEntityFactory(EntityFactory.MYSQL_JDBC);
        EntityManager em = emf.createEntityManager();

        //CARGAMOS LOS CSV
        //Insert.cargarCSV(em);

/**
        *
         * Ejercicio 2 a
         *
         * Dar de alta un estudiante.
         * *


        Student newStudent = new Student(33016244L, "Lionel", "Messi", "Alien", "Rosario", 36, 10);
        StudentRepository studentRepository = new StudentRepository(em);
        studentRepository.addStudent(newStudent);

        System.out.println("Ejercicio 1: " + em.find(Student.class, 33016244L));
 **/

/**
         * Ejercicio 2 b
         *
         * Matricular un Estudiante en una Carrera.
         * *

        // Creamos una carrera para matricular
        Career career = new Career(69, "GOAT", 4);
        CareerRepository careerRepository = new CareerRepository(em);
        careerRepository.addCareer(career);

        // Agregamos la matricula
        Tuition tuition2b = new Tuition(career, newStudent, 2, 2021, 2023);
        TuitionRepository tuitionRepository2b = new TuitionRepository(em);
        tuitionRepository2b.addTution(tuition2b);
**/
        /**
         * Ejercicio 2 c
         *
         * Recuperar todos los Estudiantes, y especificar algun criterio de ordenamiento simple.
         * *
        StudentRepository studentRepository = new StudentRepository(em);
        List<Student> students = studentRepository.getStudentsInOrder();
        System.out.println("Ejercicio 2c: \n");
        students.forEach(System.out::println);
**/

        /**
         * Ejercicio 2 d
         *
         * Recuperar un Estudiante, en base a su numero de libreta universitaria
         *
        StudentRepository studentRepository = new StudentRepository(em);
        System.out.println("Ejercicio 2 d: " + studentRepository.getStudentByUniN(15030));
**/

        /**
         * Ejercicio 2 e
         *
         * Recuperar todos los Estudiantes, en base a su Genero
         *
        StudentRepository studentRepository = new StudentRepository(em);
        System.out.println("Ejercicio 2 e: " + studentRepository.getStudentsByGenre("Male"));
**/

        /**
         * Ejercicio 2 f
         *
         * recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
         *

        TuitionRepository tuitionRepository = new TuitionRepository(em);
        List<CareerDTO> careerDTO =  tuitionRepository.getCareerWithStudentsEnrolled();
        System.out.println("Ejercicio f: "+ careerDTO);
**/

        /**
         * Ejercicio 2 g
         *
         *  recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
         *

        TuitionRepository tuitionRepo = new TuitionRepository(em);
        List<StudentDTO> studentDTO = tuitionRepo.getStudentsByCareerFilterByCiudad("TUDAI");
        System.out.println("Ejercicio 2 g: " + studentDTO);
 **/
        /**
         * Ejercicio 3 :    Generar un reporte de las carreras, que para cada carrera incluya información de los
         *                  inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
         *                  los años de manera cronológica.
         **/
        TuitionRepository tuitionRepository = new TuitionRepository(em);
        List<ReportDTO> reportDTOS = tuitionRepository.getReport();
        reportDTOS.forEach(System.out::println);


        em.close();
        emf.close();
    }
}
