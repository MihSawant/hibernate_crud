package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DbUtil {


    public static EntityManager getEntityManager(){
        var emf = Persistence.createEntityManagerFactory("mera-persistence-unit");
        return emf.createEntityManager();
    }
}
