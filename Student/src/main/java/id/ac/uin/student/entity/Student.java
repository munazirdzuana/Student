package id.ac.uin.student.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "First Name is required")
    @NotNull(message = "First Name Cant be null")
    @Column(nullable = false, name = "first_Name")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @NotNull(message = "Last Name Cant be null")
    @Column(nullable = false, name = "last_Name")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @NotNull(message = "Email Cant be null")
    @Column(nullable = false, unique = true, name = "email")
    @Email
    private String email;

    @NotEmpty(message = "Phone Number is required")
    @NotNull(message = "Phone Cant be null")
    @Size(min = 10, max = 13, message = "phone Number should be of 10 digits")
    @Column(nullable = false, unique = true, name = "phone")
    private String phoneNumber;

    @NotEmpty(message = "Jurusan is required")
    @NotNull(message = "Jurusan Cant be null")
    @Column(nullable = false, name = "jurusan")
    private String jurusan;

    @NotNull(message = "Please enter birth date")
    @Past (message = "Birth date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDay;
}
