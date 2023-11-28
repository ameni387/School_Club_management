package edu.polytech.tpchap7.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id ;
    private  String Name;



    @OneToMany(mappedBy="classroom",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("classroom")
    private List<Student> students;
}
