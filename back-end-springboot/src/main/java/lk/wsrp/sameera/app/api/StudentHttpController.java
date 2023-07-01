package lk.wsrp.sameera.app.api;

import lk.wsrp.sameera.app.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public StudentDTO saveStudent(@RequestBody @Valid StudentDTO student) {
        return null;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
    }
}
