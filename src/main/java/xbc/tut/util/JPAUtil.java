package xbc.tut.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

  private static final String PERSISTENCE_UNIT_NAME = "persistence-unit";
  private static EntityManagerFactory emFactory;

  public static EntityManagerFactory getEMFactory(){
    if (emFactory == null)
      emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    return emFactory;
  }

  public static void shutdown(){
    if (emFactory != null)
      emFactory.close();
  }

}
