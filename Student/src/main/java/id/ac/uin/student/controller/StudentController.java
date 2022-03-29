package id.ac.uin.student.controller;

import id.ac.uin.student.entity.Student;
import id.ac.uin.student.exception.StudentNotFoundException;
import id.ac.uin.student.service.StudenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudenServices studenservices;

    @Autowired
    public StudentController(StudenServices studenservices) {
        this.studenservices = studenservices;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studenservices.getAllStudents();
    }

    @GetMapping(value="/{id}")
    public Student getStudentByid(@PathVariable("id") @Min(1) Long id) {
        Student std = studenservices.findById(id).
                orElseThrow(()-> new StudentNotFoundException("Student with "+ id +" is Not Found"));
        return std;
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student std) {
        return studenservices.save(std);
    }

    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student newStd){
        Student student = studenservices.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student with "+ id +" is Not Found"));
        student.setFirstName(newStd.getFirstName());
        student.setLastName(newStd.getLastName());
        student.setEmail(newStd.getEmail());
        student.setPhoneNumber(newStd.getPhoneNumber());
        return studenservices.save(student);

    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Student std = studenservices.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        studenservices.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }

}
