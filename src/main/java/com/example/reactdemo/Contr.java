package com.example.reactdemo;

import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class Contr {

    private final Repo repo;

    public Contr(Repo repo) {
        this.repo = repo;
    }

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // GET ONE (optional)
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    // CREATE (ENTRY TIME AUTO)
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        LocalTime now = LocalTime.now();

        student.setEntryHour(now.getHour());
        student.setEntryMinute(now.getMinute());

        return repo.save(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id,
                                 @RequestBody Student student) {

        student.setId(id);
        return repo.save(student);
    }

    // CHECKOUT (EXIT TIME)
    @PutMapping("/checkout/{id}")
    public Student checkoutStudent(@PathVariable String id) {

        Student student = repo.findById(id).orElse(null);

        if (student != null) {
            LocalTime now = LocalTime.now();

            student.setExitHour(now.getHour());
            student.setExitMinute(now.getMinute());

            return repo.save(student);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        repo.deleteById(id);
    }
}