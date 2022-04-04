package id.ac.uin.student.controller;

import id.ac.uin.student.entity.Student;
import id.ac.uin.student.service.StudenServices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class StudentWebController {
    private StudenServices studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("student", new Student());
        return "formStudent";
    }


    @PostMapping(value = "/create")
    public String tambahStudent(@Valid Model model, Student student, Errors errors) {
        if(null != errors && errors.getErrorCount()>0){
            return "formStudent";
        }
        else {
            model.addAttribute("student",studentService.save(student));
            model.addAttribute("success","berhasil disimpan");
            return "succes";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }
}
