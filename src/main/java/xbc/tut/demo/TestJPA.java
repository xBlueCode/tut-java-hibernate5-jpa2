package xbc.tut.demo;

import javax.persistence.EntityManager;
import xbc.tut.util.JPAUtil;

public class TestJPA {

  public static void main(String[] args) {
    EntityManager entityManager = JPAUtil.getEMFactory().createEntityManager();

    entityManager.getTransaction().begin();

    // Check database version
    String sql = "select 'Hello Hibernate 5 & JPA 2'" ;

    String result = (String) entityManager
        .createNativeQuery(sql)
        .getSingleResult();
    System.out.println(result);

    entityManager.getTransaction().commit();
    entityManager.close();

    JPAUtil.shutdown();
  }

}