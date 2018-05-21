package xbc.tut.demo;

import java.util.Scanner;
import xbc.tut.model.Student;
import xbc.tut.service.StudentService;
import xbc.tut.service.StudentServiceImp;

public class StudentDemo {
  static StudentService studentService = new StudentServiceImp();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    boolean running = true ;
    while (running) {
      System.out.println("What do you want to do ?");
      System.out.print("Add(a), Update(u), Delete(d), Show(s), Show All(sa), Quit(q):  ");

      String choice = scanner.next();

      switch (choice){
        case "a":
          addNewStudent();
          break;
        case "u":
          updateStudent();
          break;
        case "d":
          deleteStudent();
          break;
        case "s":
          showStudent();
          break;
        case "sa":
          showAllStudents();
          break;
        case "q":
          running = !running;
          break;
        default:
          break ;
      }

    }

    exit();

  }

  public static void addNewStudent(){

    Student student = new Student();

    System.out.println("Add Student: ");

    System.out.print("Full Name: ");
    student.setFullName(scanner.next());

    System.out.print("Age: ");
    student.setAge(scanner.nextInt());

    studentService.add(student);
  }

  private static void updateStudent() {
    Student student = new Student();

    System.out.println("Update Student: ");

    System.out.print("Student ID: ");
    student.setId(scanner.nextInt());

    System.out.print("Full Name (Without spaces): ");
    student.setFullName(scanner.next());

    System.out.print("Age: ");
    student.setAge(scanner.nextInt());

    studentService.update(student);
  }

  private static void deleteStudent() {

    Student student = new Student();

    System.out.print("Delete Student with ID: ");
    student.setId(scanner.nextInt());

    studentService.delete(student);
  }

  private static void showStudent() {

    System.out.print("Show Student with the ID: ");

    Student student = studentService.get(scanner.nextInt());

    System.out.println( student!=null ? student : "Student Not Found" );

  }

  private static void showAllStudents() {
    System.out.println("List of Students");
    studentService.getAll().stream()
        .forEach(System.out::println);
  }

  public static void exit(){
    // Close the database access before exiting the program
    studentService.shutdown();
  }

}