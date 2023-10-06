package factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MyFactoryEntityManager {
    private static final String PERSISTENCE_NAME = "Integrador2";
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);

    public static EntityManagerFactory getEntityManager() {
        return emf;
    }
}
