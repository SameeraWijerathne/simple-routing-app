package lk.wsrp.sameera.app.dao.custom.impl;

import lk.wsrp.sameera.app.dao.custom.StudentDAO;
import lk.wsrp.sameera.app.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static lk.wsrp.sameera.app.dao.custom.util.Mappers.STUDENT_ROW_MAPPER;
@Repository
public class StudentDAOImpl implements StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() throws Exception {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Long.class);
    }
    @Override
    public Student save(Student student) throws Exception {
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(con ->{
            PreparedStatement stm = con.prepareStatement("INSERT INTO student (name, address) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, student.getName());
            stm.setString(2, student.getAddress());
            return stm;
        }, kh);
        student.setId(kh.getKey().intValue());
        return student;
    }

    @Override
    public void update(Student student) throws Exception {
        jdbcTemplate.update("UPDATE student SET name=?, address=? WHERE id=?",
                student.getName(), student.getAddress(), student.getId());
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
    }

    @Override
    public Optional<Student> findById(Integer pk) throws Exception {
        try {
            return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?", STUDENT_ROW_MAPPER, pk));
        } catch (DataAccessException exp) {
            return Optional.empty();
        }
    }

    @Override
    public List<Student> findAll() throws Exception {
        return jdbcTemplate.query("SELECT * FROM student", STUDENT_ROW_MAPPER);
    }

    @Override
    public boolean existsById(Integer id) throws Exception {
        return findById(id).isPresent();
    }
}
