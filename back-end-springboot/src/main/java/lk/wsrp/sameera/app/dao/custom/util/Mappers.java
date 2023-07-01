package lk.wsrp.sameera.app.dao.custom.util;

import lk.wsrp.sameera.app.entity.Student;
import org.springframework.jdbc.core.RowMapper;

public class Mappers {
    public static final RowMapper<Student> STUDENT_ROW_MAPPER = ((rs, rowNum)->{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        return new Student(id, name, address);
    });
}
