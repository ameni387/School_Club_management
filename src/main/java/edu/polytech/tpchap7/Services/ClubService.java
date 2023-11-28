package edu.polytech.tpchap7.Services;

import edu.polytech.tpchap7.Models.Club;


import java.util.List;

public interface ClubService {
    Club saveClub (Club club);

    // read operation
    List<Club> fetchClubList();

    // update operation
    Club updateClub(Club club, Integer clubId);

    // delete operation
    void deleteClubById(Integer clubId);
    Club getClubById(Integer clubId);
    //List<Club> getClubsByStudentNsc(Long studentNsc);
}
