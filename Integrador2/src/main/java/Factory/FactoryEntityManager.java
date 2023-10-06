package Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FactoryEntityManager {
    private static final String  PERSISTENCE_NAME = "Integrador2";
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    public static EntityManagerFactory getEntityManager(){
        return emf;
    }
}
