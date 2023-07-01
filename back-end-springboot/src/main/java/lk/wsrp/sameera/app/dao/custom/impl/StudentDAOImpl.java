package lk.wsrp.sameera.app.dao.custom.impl;

import lk.wsrp.sameera.app.dao.custom.StudentDAO;
import lk.wsrp.sameera.app.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public long count() throws Exception {
        return 0;
    }

    @Override
    public Student save(Student entity) throws Exception {
        return null;
    }

    @Override
    public void update(Student entity) throws Exception {

    }

    @Override
    public void deleteById(Integer pk) throws Exception {

    }

    @Override
    public Optional<Student> findById(Integer pk) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean existsById(Integer pk) throws Exception {
        return false;
    }
}
