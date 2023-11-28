package edu.polytech.tpchap7.Services;

import edu.polytech.tpchap7.Models.Classroom;

import java.util.List;

public interface ClassroomService {
    // save operation
    Classroom saveClassroom (Classroom classroom);

    // read operation
    List<Classroom> fetchClassroomList();

    // update operation
    Classroom updateClassroom(Classroom classroom, Integer classroomId);

    // delete operation
    void deleteClassroomById(Integer classroomId);
    //get by id operation
    Classroom getClassroomById(Integer classroomId);
}
