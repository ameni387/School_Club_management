package edu.polytech.tpchap7.Services;

import edu.polytech.tpchap7.Models.Student;
import edu.polytech.tpchap7.Repositorys.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);


    }

    @Override
    public List<Student> fetchStudentList() {
        return (List<Student>) studentRepository.findAll();

    }
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

   /* @Override
    public List<Student> getStudentsByClubRef(Long clubRef) {
        return studentRepository.findByClubsRef(clubRef);
    }*/

    @Override
    public Student updateStudent(Student student, Integer studentId) {
        Student existingStudent = getStudentById(studentId);
        existingStudent.setEmail(student.getEmail());
        existingStudent.setClassroom(student.getClassroom());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

}
