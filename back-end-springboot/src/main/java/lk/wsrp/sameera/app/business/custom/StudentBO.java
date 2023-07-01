package lk.wsrp.sameera.app.business.custom;

import lk.wsrp.sameera.app.dto.StudentDTO;

import java.util.List;

public interface StudentBO {
    List<StudentDTO> getAllStudents() throws Exception;

    StudentDTO saveStudent(StudentDTO studentDTO) throws Exception;

    void deleteStudent(int studentId) throws Exception;
}
