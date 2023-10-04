import entities.Student;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileReader;
import java.io.IOException;

public class Insert {
    private static String pathFilesCsv = "./src/main/resources/csv/";
    private static final String STUDENT_FILE = "students.csv", PERSISTENCE_NAME = "Integrador2";

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    protected static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {

        em.getTransaction().begin();

        Student p = null;
        System.out.print("Cargando estudiantes .....................");
        CSVParser parser = getCSVParser(STUDENT_FILE);
        for (CSVRecord row : parser) {
            System.out.println(row.get(0) + " , "  +  row.get(1) +  ", " +  row.get(2) +  ", " +  row.get(4) +  ", " +   Integer.parseInt(row.get(5))  +  ", " +  Integer.parseInt(row.get(6)));
            Long dni =  Long.parseLong(row.get(0));
            String name  = row.get(1);
            String lastName  = row.get(2);
            String city  = row.get(4);
            Integer age  =  Integer.parseInt(row.get(5));
            Integer uniNumber  =  Integer.parseInt(row.get(6));
            p = new Student(dni,name,lastName,city,age,uniNumber);
            em.persist(p);
            System.out.println(p);
            System.out.print(".");
        }
        System.out.print(" .....................PROCESO FINALIZADO \n ");


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
