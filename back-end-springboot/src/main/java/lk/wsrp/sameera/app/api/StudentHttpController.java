package lk.wsrp.sameera.app.api;

import lk.wsrp.sameera.app.business.custom.StudentBO;
import lk.wsrp.sameera.app.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {
    private final StudentBO studentBO;

    public StudentHttpController(StudentBO studentBO) {
        this.studentBO = studentBO;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentBO.getAllStudents();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public StudentDTO saveStudent(@RequestBody @Valid StudentDTO student) throws Exception {
        return studentBO.saveStudent(student);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) throws Exception {
        studentBO.deleteStudent(studentId);
    }
}
