package edu.polytech.tpchap7.Repositorys;

import edu.polytech.tpchap7.Models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
   // List<Student> findByClubsRef(Long tutorialId);
}
