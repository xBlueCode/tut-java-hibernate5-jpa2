package xbc.tut.service;

import java.util.List;
import xbc.tut.dao.StudentDAO;
import xbc.tut.dao.StudentDAOImp;
import xbc.tut.model.Student;

public class StudentServiceImp implements StudentService {

  StudentDAO studentDAO ;

  public StudentServiceImp(){
    studentDAO = new StudentDAOImp();
  }

  @Override
  public int add(Student student) {
    return studentDAO.addStudent(student);
  }

  @Override
  public void update(Student student) {
    studentDAO.updateStudent(student);
  }

  @Override
  public void delete(Student student) {
    studentDAO.deleteStudent(student);
  }

  @Override
  public Student get(int id) {
    return studentDAO.getStudentById(id);
  }

  @Override
  public List<Student> getAll() {
    return studentDAO.getAllStudent();
  }

  @Override
  public void shutdown() {
    studentDAO.close();
  }
}
