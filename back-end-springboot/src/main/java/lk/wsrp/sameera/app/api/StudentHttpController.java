package lk.wsrp.sameera.app.api;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {
    @GetMapping
    public String getAllStudents() {
        return "get()";
    }

    @PostMapping
    public String saveStudent() {
        return "post()";
    }

    @DeleteMapping
    public String deleteStudent() {
        return "delete()";
    }
}
