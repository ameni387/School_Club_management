package edu.polytech.tpchap7.Repositorys;

import edu.polytech.tpchap7.Models.Club;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClubRepository extends CrudRepository<Club,Integer> {
    //List<Club> findByStudentsNsc(Long studentNsc);
}
