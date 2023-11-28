package edu.polytech.tpchap7.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer REF;

    private Date Creation_date;

    @ManyToMany(mappedBy = "clubs",fetch = FetchType.LAZY)
    List<Student> students;


    public Set<Student> getTutorials() {
        return (Set<Student>) students;
    }

    public void setTutorials(Set<Student> students) {
        this.students = (List<Student>) students;
    }
}
