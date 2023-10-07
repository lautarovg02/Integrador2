package factory;

import repository.CareerRepository;
import repository.StudentRepository;
import repository.TuitionRepository;

import javax.persistence.EntityManagerFactory;

public abstract class EntityFactory {

    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;
    public static final int JPA_HIBERNATE = 3;

    public abstract CareerRepository careerRepo();

    public abstract StudentRepository studentRepo();

    public abstract TuitionRepository tuitionRepo();


    public static EntityManagerFactory getEntityFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC:
                return MyFactoryEntityManager.getEntityManager();
//            case DERBY_JDBC: return new DerbyJDBCDAOFactory();
//            case JPA_HIBERNATE: …
            default:
                return null;
        }
    }
}
