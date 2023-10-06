package main;

import Factory.MyFactoryEntityManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.FileReader;
import java.io.IOException;

public class Insert {
    private static String pathFilesCsv = "./src/main/resources/csv/";
    private static final String STUDENT_FILE = "students.csv", TUITION_CSV = "tuition.csv", CAREER_FILE = "career.csv", PERSISTENCE_NAME = "Integrador2";

    public static void main(String[] args) {
        EntityManagerFactory emf = MyFactoryEntityManager.getEntityManager();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        /*** CARGAR DE UNA ENTIDAD A LA VES */

//        Student p = null;
//        System.out.print("Cargando estudiantes .....................");
//        CSVParser parser = getCSVParser(STUDENT_FILE);
//        for (CSVRecord row : parser) {
//            System.out.println(row.get(0) + " , "  +  row.get(1) +  ", " +  row.get(2) +  ", " +  row.get(4) +  ", " +   Integer.parseInt(row.get(5))  +  ", " +  Integer.parseInt(row.get(6)));
//            Long dni =  Long.parseLong(row.get(0));
//            String name  = row.get(1);
//            String lastName  = row.get(2);
//            String city  = row.get(4);
//            Integer age  =  Integer.parseInt(row.get(5));
//            Integer uniNumber  =  Integer.parseInt(row.get(6));
//            p = new Student(dni,name,lastName,city,age,uniNumber);
//            em.persist(p);
//            System.out.println(p);
//            System.out.print(".");
//        }
//        System.out.print(" .....................PROCESO FINALIZADO \n ");

        /*** CARGAR DE UNA ENTIDAD A LA VES */

//        Career c = null;
//        System.out.print("Cargando Career .....................");
//        CSVParser parser = getCSVParser(CAREER_FILE);
//        for (CSVRecord row : parser) {
//           c = new Career(Long.parseLong(row.get(0)), row.get(1), Integer.parseInt(row.get(2)));
//            System.out.println(c);
//            em.persist(c);
//        }
//        System.out.print(" .....................PROCESO FINALIZADO \n ");

//        Tuition t = null;
//        System.out.print("Cargando TUITON_FILE .....................");
//        CSVParser parser = getCSVParser(TUITION_CSV);
//        long counter = 0;
//        for (CSVRecord row : parser) {
//            Student s = em.find(Student.class, Long.parseLong(row.get(0)));
//            Career c = em.find(Career.class, Long.parseLong(row.get(1)));
//            t = new Tuition(Integer.parseInt(row.get(2)), s, c, false);
//            System.out.println(t);
//            em.persist(t);
//        }
//        System.out.print(" .....................PROCESO FINALIZADO \n ");

        // CLOSE
        em.getTransaction().commit();
        em.close();
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
