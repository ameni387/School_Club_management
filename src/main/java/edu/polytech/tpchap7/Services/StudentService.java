package edu.polytech.tpchap7.Services;

import edu.polytech.tpchap7.Models.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent (Student student);

    // read operation
    List<Student> fetchStudentList();

    // update operation
    Student updateStudent(Student student, Integer studentId);

    // delete operation
    void deleteStudentById(Integer studentId);
    Student getStudentById(Integer studentId);
   // List<Student> getStudentsByClubRef(Long clubRef);
}
