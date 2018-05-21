package xbc.tut.dao;

import java.util.List;
import xbc.tut.model.Student;

public interface StudentDAO {

  int addStudent(Student student);

  void updateStudent(Student student);

  void deleteStudent(Student student);

  Student getStudentById(int id);

  List<Student> getAllStudent();

  void close();

}
