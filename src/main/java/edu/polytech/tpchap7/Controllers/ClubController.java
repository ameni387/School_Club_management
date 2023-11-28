package edu.polytech.tpchap7.Controllers;

import edu.polytech.tpchap7.Models.Club;

import edu.polytech.tpchap7.Services.ClubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @PostMapping("/clubs")
    public Club saveClub(@RequestBody Club club)
    {
        return clubService.saveClub(club);
    }

    @GetMapping("/Allclubs")

    public List<Club> fetchClubList()
    {
        return clubService.fetchClubList();
    }
    @DeleteMapping("/club/{id}")
    public String deleteClubById(@PathVariable("id")
                                    Integer clubId) {
        try {
            clubService.deleteClubById(clubId);
            return String.valueOf(new ResponseEntity<>(HttpStatus.NO_CONTENT));
            //return "Deleted Successfully";
        } catch (Exception e) {
            return String.valueOf(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/updateclub/{id}")
    public ResponseEntity<Club> updateClub( @RequestBody Club club,@PathVariable Integer clubId) {
        Club updatedClub = clubService.updateClub(club,clubId);
        return ResponseEntity.ok(updatedClub);
    }

   /* @GetMapping("/clubs/byStudentNsc/{studentNsc}")
    public ResponseEntity<List<Club>> getClubsByStudentNsc(@PathVariable Long studentNsc) {
        List<Club> clubsForStudent = clubService.getClubsByStudentNsc(studentNsc);
        return ResponseEntity.ok(clubsForStudent);
    }*/
}
