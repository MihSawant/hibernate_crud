package main;

import entities.Student;

import service.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        StudentService service = new StudentService();


            // inserting some data into the db, so we get something to start with
            List<Student> nerds = List.of(new Student(1, "yash"),
                    new Student(2, "hari"), new Student(3, "suresh"),
                    new Student(4, "azirel"), new Student(5, "aayan"),
                    new Student(6, "shayan"));


//           for(Student student : nerds){
//               service.saveStudent(student);
//           }
            service.saveStudent(new Student(77111, "XYZ"));
           service.findAllStudents().forEach(System.out::println);
//           service.updateStudentById("harikrishnan", 2);
           service.deleteStudentByName("X");
    }
}
