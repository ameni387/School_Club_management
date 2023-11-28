package edu.polytech.tpchap7.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer NSC;
    private String Email;

    @ManyToMany
    @JoinTable(
            name = "Integrate_In_Club",
            joinColumns = @JoinColumn(name = "NSC"),
            inverseJoinColumns = @JoinColumn(name = "REF"))

    List<Club> clubs;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="ClassRoom_Id")
    @JsonIgnore
    private Classroom classroom;


    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public void addClub(Club club) {
        this.clubs.add(club);
        club.getStudents().add(this);
    }

    public void removeClub(long clubId) {
        Club club = this.clubs.stream().filter(t -> t.getREF().equals(clubId)).findFirst().orElse(null);
        if (club != null) {
            this.clubs.remove(club);
            club.getStudents().remove(this);
        }
    }

}
