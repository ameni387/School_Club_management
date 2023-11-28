package edu.polytech.tpchap7.Services;

import edu.polytech.tpchap7.Models.Classroom;
import edu.polytech.tpchap7.Repositorys.ClassroomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClassroomServiceImpl implements ClassroomService{
    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
     ClassroomRepository classroomRepository;
    @Override
    public Classroom saveClassroom(Classroom classroom) {

        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> fetchClassroomList() {

        return (List<Classroom>) classroomRepository.findAll();
    }
    @Override
    public  Classroom getClassroomById(Integer classroomId) {
        return classroomRepository.findById(classroomId).
                orElseThrow(()-> new EntityNotFoundException("Classroom not found with id:"+classroomId));

    }

    @Override
    public Classroom updateClassroom(Classroom classroom, Integer classroomId) {
        Classroom existingClassroom = getClassroomById(classroomId);
        existingClassroom.setName(classroom.getName());
        existingClassroom.setName(classroom.getStudents().toString());
        return classroomRepository.save(existingClassroom);



    }

    @Override
    public void deleteClassroomById(Integer classroomId) {
            classroomRepository.deleteById(classroomId);
    }


}
