package main;

import dao.StudentDAO;
import dao.TuitionDAO;
import entities.Career;
import entities.Student;
import entities.Tuition;
import factory.MyFactoryEntityManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.FileReader;
import java.io.IOException;

public class Insert {
    private static String pathFilesCsv = "./src/main/resources/csv/";
    private static final String STUDENT_FILE = "estudiantes.csv", TUITION_CSV = "estudianteCarrera.csv", CAREER_FILE = "carreras.csv", PERSISTENCE_NAME = "Integrador2";

    public static void main(String[] args) {
        //EMTITY MANAGER
        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();
        // EJERCICIO 2-B
        Tuition t = null;
        System.out.print("Cargando TUITON_FILE .....................");
        CSVParser parser = getCSVParser(TUITION_CSV);
        long counter = 0;
        TuitionDAO tDAO = new TuitionDAO(em);
        for (CSVRecord row : parser) {
            Student student = em.find(Student.class, Long.parseLong(row.get(1)));
            Career career = em.find(Career.class, Long.parseLong(row.get(2)));
            int inscription = Integer.parseInt(row.get(3));
            int antiquity = Integer.parseInt(row.get(5));
            int graduate = Integer.parseInt(row.get(4));
            t = new Tuition(career,student,antiquity, inscription , graduate);
            System.out.println(t);
            tDAO.addTution(t);
        }
        em.close();
        System.out.print(" .....................PROCESO FINALIZADO \n ");






//        //EJERCICIO 2-A
//        Student newStudent = null;
//        StudentDAO studentDAO = new StudentDAO(em);
//        CSVParser parser = getCSVParser(STUDENT_FILE);
//        for (CSVRecord row : parser) {
//            Long dni =  Long.parseLong(row.get(0));
//            String name  = row.get(1);
//            String lastName  = row.get(2);
//            Integer age  =  Integer.parseInt(row.get(3));
//            String genere = row.get(4);
//            String city  = row.get(5);
//            Integer uniNumber  =  Integer.parseInt(row.get(6));
//            newStudent = new Student(dni,name,lastName,genere,city,age,uniNumber);
//            System.out.println(newStudent);
//           studentDAO.addStudent(newStudent);
//        }
//        em.close();//Lo dejamos sino se rompe por abrir y cerrar muchas conexiones

        /*
         * CARGANDO ENTIDADES SIN DAOS
         */
//        em.getTransaction().begin(); //** DESCOMENTAR EN CASO DE CARGAR ENTIDADES SIN DAO  Y DESCOMENTAR 97 y 98**
//        Student p = null;
//        System.out.print("Cargando estudiantes .....................");
//        CSVParser parserStudents = getCSVParser(STUDENT_FILE);
//        for (CSVRecord row : parserStudents) {
//            Long dni =  Long.parseLong(row.get(0));
//            String name  = row.get(1);
//            String lastName  = row.get(2);
//            Integer age  =  Integer.parseInt(row.get(3));
//            String genere = row.get(4);
//            String city  = row.get(5);
//            Integer uniNumber  =  Integer.parseInt(row.get(6));
//            newStudent = new Student(dni,name,lastName,genere,city,age,uniNumber);
//            em.persist(p);
//            System.out.println(p);
//            System.out.print(".");
//        }
//        System.out.print(" .....................PROCESO FINALIZADO \n ");

        /*** CARGAR DE UNA ENTIDAD A LA VES */
//
//        Career c = null;
//        System.out.print("Cargando Career .....................");
//        CSVParser parserCareer = getCSVParser(CAREER_FILE);
//        for (CSVRecord row : parserCareer) {
//           c = new Career(Long.parseLong(row.get(0)), row.get(1), Integer.parseInt(row.get(2)));
//            System.out.println(c);
//            em.persist(c);
//        }
//        System.out.print(" .....................PROCESO FINALIZADO \n ");


//        /*** CARGAR DE UNA ENTIDAD A LA VES */
//        em.getTransaction().begin();
//        Tuition t = null;
//        System.out.print("Cargando TUITON_FILE .....................");
//        CSVParser parser = getCSVParser(TUITION_CSV);
//        long counter = 0;
//        for (CSVRecord row : parser) {
//            Student student = em.find(Student.class, Long.parseLong(row.get(1)));
//            Career career = em.find(Career.class, Long.parseLong(row.get(2)));
//            int inscription = Integer.parseInt(row.get(3));
//            int antiquity = Integer.parseInt(row.get(5));
//            int graduate = Integer.parseInt(row.get(4));
//            t = new Tuition(career,student,antiquity, inscription , graduate);
//            System.out.println(t);
//            em.persist(t);
//        }
//        System.out.print(" .....................PROCESO FINALIZADO \n ");



        // CLOSE
//        em.getTransaction().commit();
//        em.close();
        emf.close();
    }







    private static CSVParser getCSVParser(String file) {
        CSVParser p = null;
        try {
            p = CSVFormat.DEFAULT.withHeader().parse(new FileReader(pathFilesCsv + file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p;
    }
}
