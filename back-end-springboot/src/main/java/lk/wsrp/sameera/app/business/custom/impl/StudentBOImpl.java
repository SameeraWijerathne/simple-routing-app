package lk.wsrp.sameera.app.business.custom.impl;

import lk.wsrp.sameera.app.business.custom.StudentBO;
import lk.wsrp.sameera.app.business.exception.DuplicateRecordException;
import lk.wsrp.sameera.app.business.exception.RecordNotFoundException;
import lk.wsrp.sameera.app.business.util.Transformer;
import lk.wsrp.sameera.app.dao.custom.StudentDAO;
import lk.wsrp.sameera.app.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentDAO.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws Exception {
        return transformer.fromStudentEntity(studentDAO.save(transformer.toStudentEntity(studentDTO)));
    }

    @Override
    public void deleteStudent(int studentId) throws Exception {
        if (!studentDAO.existsById(studentId)) {
            throw new RecordNotFoundException("No record was found associate with the id: " + studentId);
        }
        studentDAO.deleteById(studentId);
    }
}
