package xbc.tut.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import xbc.tut.model.Student;
import xbc.tut.util.JPAUtil;


@Transactional
public class StudentDAOImp implements StudentDAO {

  //@PersistenceContext
  private EntityManager entityManager;

  public StudentDAOImp(){
    entityManager = JPAUtil.getEMFactory().createEntityManager();
  }

  @Override
  public int addStudent(Student student) {
    entityManager.getTransaction().begin();
    entityManager.persist(student);
    entityManager.getTransaction().commit();
    return student.getId();
  }

  @Override
  public void updateStudent(Student student) {
    entityManager.getTransaction().begin();
    entityManager.merge(student);
    entityManager.getTransaction().commit();
  }

  @Override
  public void deleteStudent(Student student) {
    entityManager.getTransaction().begin();
    entityManager.remove(student);
    entityManager.getTransaction().commit();
  }

  @Override
  public Student getStudentById(int id) {
    return entityManager.find(Student.class, id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Student> getAllStudent() {

    CriteriaQuery criteria= entityManager
        .getCriteriaBuilder()
        .createQuery(Student.class);

    criteria.from(Student.class);

    //Query query = entityManager.createQuery(criteria);

    return entityManager
        .createQuery(criteria)
        .getResultList();

//--- Alternative method ---

//    String sqlQuery = "select * from student" ;
//
//    return  entityManager
//        .createNativeQuery(sqlQuery, Student.class)
//        .getResultList();

  }

  @Override
  public void close() {
    entityManager.close();
  }
}