package ro.devmind.springsecurityauthorization.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.devmind.springsecurityauthorization.dto.CourseRequestDTO;
import ro.devmind.springsecurityauthorization.dto.CourseSuccessResponseDTO;
import ro.devmind.springsecurityauthorization.models.Materie;
import ro.devmind.springsecurityauthorization.models.Profesor;
import ro.devmind.springsecurityauthorization.repositories.MaterieRepository;
import ro.devmind.springsecurityauthorization.repositories.ProfesorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final ProfesorRepository profesorRepository;
    private final MaterieRepository materieRepository;

    @Autowired
    public CourseController(ProfesorRepository profesorRepository, MaterieRepository materieRepository) {
        this.profesorRepository = profesorRepository;
        this.materieRepository = materieRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody ResponseEntity<List<Materie>> getCourses() {
        List<Materie> courses = materieRepository.findAll();
        return new ResponseEntity<>(courses, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{courseId}")
    @PostAuthorize("returnObject.profesor.name == authentication.name")
    public @ResponseBody Materie getCourseById(@PathVariable Integer courseId) {
        return materieRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @PostMapping()
    public @Transactional @ResponseBody ResponseEntity<CourseSuccessResponseDTO> addTeacher(@RequestBody CourseRequestDTO courseRequestDTO) {
        Profesor profesor = profesorRepository.findByName(courseRequestDTO.getProfesorName());
        if (profesor == null) {
            throw new RuntimeException("Profesor not found");
        }

        Materie materie = new Materie();
        materie.setName(courseRequestDTO.getName());
        materie.setProfesor(profesor);
        materieRepository.save(materie);
        return new ResponseEntity<>(new CourseSuccessResponseDTO(materie.getName(), profesor.getName()), HttpStatus.CREATED);
    }
}
