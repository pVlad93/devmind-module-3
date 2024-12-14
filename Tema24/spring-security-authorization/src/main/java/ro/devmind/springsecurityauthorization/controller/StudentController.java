package ro.devmind.springsecurityauthorization.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.devmind.springsecurityauthorization.dto.StudentEnrolledCoursesDTO;
import ro.devmind.springsecurityauthorization.dto.StudentRequestDTO;
import ro.devmind.springsecurityauthorization.dto.StudentSuccessResponseDTO;
import ro.devmind.springsecurityauthorization.models.Materie;
import ro.devmind.springsecurityauthorization.models.Student;
import ro.devmind.springsecurityauthorization.repositories.MaterieRepository;
import ro.devmind.springsecurityauthorization.repositories.StudentRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final MaterieRepository materieRepository;

    public StudentController(StudentRepository studentRepository, MaterieRepository materieRepository) {
        this.studentRepository = studentRepository;
        this.materieRepository = materieRepository;
    }

    @PostMapping("/join")
    public @Transactional @ResponseBody ResponseEntity<StudentSuccessResponseDTO> addTeacher(@RequestBody StudentRequestDTO studentRequestDTO) {
        String loggedStudentName = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Student> student = studentRepository.findByName(loggedStudentName);
        if (student.isEmpty()) {
            throw new RuntimeException("Student error");
        }
        Student foundStudent = student.get();
        Optional<Materie> materie = materieRepository.findByName(studentRequestDTO.getMaterieName());
        if (materie.isEmpty()) {
            throw new RuntimeException("Materie not found");
        }
        Materie foundMaterie = materie.get();
        foundStudent.getMaterii().add(foundMaterie);

        studentRepository.save(foundStudent);

        return new ResponseEntity<>(new StudentSuccessResponseDTO(loggedStudentName, foundMaterie.getName()), HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    public @ResponseBody ResponseEntity<StudentEnrolledCoursesDTO> getCoursesOfStudent() {
        String loggedStudentName = SecurityContextHolder.getContext().getAuthentication().getName();
        Set<Materie> materiiByName = studentRepository.findMateriiByName(loggedStudentName);
        return new ResponseEntity<>(new StudentEnrolledCoursesDTO(materiiByName), HttpStatus.OK);
    }

}
