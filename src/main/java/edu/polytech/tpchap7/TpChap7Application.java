package edu.polytech.tpchap7;

import edu.polytech.tpchap7.Models.Classroom;
import edu.polytech.tpchap7.Models.Student;
import edu.polytech.tpchap7.Repositorys.ClassroomRepository;
import edu.polytech.tpchap7.Repositorys.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class TpChap7Application {

    public static void main(String[] args) {
        SpringApplication.run(TpChap7Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ClassroomRepository repository) {
    Classroom class1= new Classroom();
    Student student1=new Student();
    Student student2= new Student();

        List<Student> StudentList=new ArrayList<Student>();
        StudentList.add(student1);
        StudentList.add(student2);
        return (args) -> {
            repository.save(new Classroom(1,"class1",StudentList));

        };
    }
}
