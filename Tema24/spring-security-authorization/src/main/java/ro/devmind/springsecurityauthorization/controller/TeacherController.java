package ro.devmind.springsecurityauthorization.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.devmind.springsecurityauthorization.dto.TeacherRequestDTO;
import ro.devmind.springsecurityauthorization.dto.TeacherSuccessResponseDTO;
import ro.devmind.springsecurityauthorization.models.Materie;
import ro.devmind.springsecurityauthorization.models.Profesor;
import ro.devmind.springsecurityauthorization.repositories.MaterieRepository;
import ro.devmind.springsecurityauthorization.repositories.ProfesorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final ProfesorRepository profesorRepository;
    private final MaterieRepository materieRepository;

    @Autowired
    public TeacherController(ProfesorRepository profesorRepository, MaterieRepository materieRepository) {
        this.profesorRepository = profesorRepository;
        this.materieRepository = materieRepository;
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<TeacherSuccessResponseDTO>> getTeachers() {
        Iterable<Profesor> teachers = profesorRepository.findAll();;

        List<TeacherSuccessResponseDTO> response = new ArrayList<>();
        for (Profesor teacher : teachers) {
            response.add(new TeacherSuccessResponseDTO(teacher.getId(), teacher.getName(), teacher.getMaterii()));
        }

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public @Transactional @ResponseBody ResponseEntity<TeacherSuccessResponseDTO> addTeacher(@RequestBody TeacherRequestDTO teacher) {
        Profesor profesor = new Profesor();
        profesor.setName(teacher.getTeacherName());
        profesor = profesorRepository.save(profesor);

        Materie materie = new Materie();
        materie.setName(teacher.getCourseName());
        materie.setProfesor(profesor);
        materieRepository.save(materie);

        return new ResponseEntity<>(new TeacherSuccessResponseDTO(profesor.getId(), profesor.getName(), Set.of(materie)), HttpStatus.CREATED);
    }
}
