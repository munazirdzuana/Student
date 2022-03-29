package id.ac.uin.student.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "First Name is required")
    @Column(nullable = false, name = "firstName")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @Column(nullable = false, name = "lastName")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @NotEmpty(message = "Phone Number is required")
    @Column(nullable = false, unique = true, name = "phone")
    private String phoneNumber;

    @NotEmpty(message = "Jurusan is required")
    @Column(nullable = false, name = "jurusan")
    private String jurusan;
}
