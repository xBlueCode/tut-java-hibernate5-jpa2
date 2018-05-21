package xbc.tut.service;

import java.util.List;
import xbc.tut.model.Student;

public interface StudentService {

  int add(Student student);

  void update(Student student);

  void delete(Student student);

  Student get(int id);

  List<Student> getAll();

  void shutdown();

}