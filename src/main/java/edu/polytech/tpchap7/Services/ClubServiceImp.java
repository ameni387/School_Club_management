package edu.polytech.tpchap7.Services;

import edu.polytech.tpchap7.Models.Club;
import edu.polytech.tpchap7.Repositorys.ClubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImp implements ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public List<Club> fetchClubList() {
        return (List<Club>) clubRepository.findAll();
    }

    @Override
    public Club updateClub(Club club, Integer clubId) {
        Club existingClub = getClubById(clubId);
        existingClub.setCreation_date(club.getCreation_date());
        return clubRepository.save(existingClub);
    }

    @Override
    public void deleteClubById(Integer clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public Club getClubById(Integer clubId) {
        return clubRepository.findById(clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club not found with id: " + clubId));
    }

   /* @Override
    public List<Club> getClubsByStudentNsc(Long studentNsc) {
        return clubRepository.findByStudentsNsc(studentNsc);
    }*/
}
