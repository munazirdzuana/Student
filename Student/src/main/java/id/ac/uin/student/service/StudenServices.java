package id.ac.uin.student.service;

import id.ac.uin.student.entity.Student;
import org.hibernate.sql.Delete;

import java.util.List;
import java.util.Optional;

public interface StudenServices {
    List<Student> getAllStudents();

    Optional<Student> findById(Long id);

    Optional<Student> findByEmail(String email);

    Student save(Student std);

    void deleteById(long id);
}
