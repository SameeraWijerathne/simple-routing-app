package lk.wsrp.sameera.app.business.util;

import lk.wsrp.sameera.app.dto.StudentDTO;
import lk.wsrp.sameera.app.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Student toStudentEntity(StudentDTO studentDTO) {
        return mapper.map(studentDTO, Student.class);
    }

    public StudentDTO fromStudentEntity(Student studentEntity) {
        return mapper.map(studentEntity, StudentDTO.class);
    }
}
