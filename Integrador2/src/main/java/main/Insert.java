package main;

import repository.CareerRepository;
import repository.StudentRepository;
import repository.TuitionRepository;
import entities.Career;
import entities.Student;
import entities.Tuition;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;

public class Insert {
    private static String pathFilesCsv = "./src/main/resources/csv/";
    private static final String STUDENT_FILE = "estudiantes.csv", TUITION_CSV = "estudianteCarrera.csv", CAREER_FILE = "carreras.csv", PERSISTENCE_NAME = "Integrador2";

    public static void cargarCSV(EntityManager em) {
        //EMTITY MANAGER

        insertStudents(em);

        insertCareers(em);

        insertTuitions(em);
    }

    private static void insertStudents(EntityManager em) {
        //EJERCICIO 2-A
        Student newStudent = null;
        StudentRepository studentDAO = new StudentRepository(em);
        CSVParser parser = getCSVParser(STUDENT_FILE);
        for (CSVRecord row : parser) {
            Long dni = Long.parseLong(row.get(0));
            String name = row.get(1);
            String lastName = row.get(2);
            Integer age = Integer.parseInt(row.get(3));
            String genere = row.get(4);
            String city = row.get(5);
            Integer uniNumber = Integer.parseInt(row.get(6));
            newStudent = new Student(dni, name, lastName, genere, city, age, uniNumber);
            System.out.println(newStudent);
            studentDAO.addStudent(newStudent);
        }
        System.out.print(" .....................PROCESO FINALIZADO \n ");

    }

    private static void insertCareers(EntityManager em) {
        Career c = null;
        CareerRepository cDAO = new CareerRepository(em);
        System.out.print("Cargando Career .....................");
        CSVParser parserCareer = getCSVParser(CAREER_FILE);
        for (CSVRecord row : parserCareer) {
            c = new Career(Long.parseLong(row.get(0)), row.get(1), Integer.parseInt(row.get(2)));
            System.out.println(c);
            cDAO.addCareer(c);
        }
        System.out.print(" .....................PROCESO FINALIZADO \n ");
    }

    private static void insertTuitions(EntityManager em) {
        Tuition t = null;
        System.out.print("Cargando TUITON_FILE .....................");
        CSVParser parser = getCSVParser(TUITION_CSV);
        TuitionRepository tDAO = new TuitionRepository(em);
        for (CSVRecord row : parser) {
            Student student = em.find(Student.class, Long.parseLong(row.get(1)));
            Career career = em.find(Career.class, Long.parseLong(row.get(2)));
            int inscription = Integer.parseInt(row.get(3));
            int antiquity = Integer.parseInt(row.get(5));
            int graduate = Integer.parseInt(row.get(4));
            t = new Tuition(career, student, antiquity, inscription, graduate);
            System.out.println(t);
            tDAO.addTution(t);
        }
        System.out.print(" .....................PROCESO FINALIZADO \n ");
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
