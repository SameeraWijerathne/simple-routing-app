package lk.wsrp.sameera.app.business.custom.impl;

import lk.wsrp.sameera.app.business.custom.StudentBO;
import lk.wsrp.sameera.app.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentBOImpl implements StudentBO {
    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return null;
    }

    @Override
    public StudentDTO saveStudent() throws Exception {
        return null;
    }

    @Override
    public void deleteStudent() throws Exception {

    }
}
