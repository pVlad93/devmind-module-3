package ro.devmind.demohibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.devmind.demohibernate.models.Profesor;
import ro.devmind.demohibernate.services.ProfesorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    private final ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    // 1a
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profesor>> getProfesorById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(profesorService.findById(id));
    }

    // 1b
    @GetMapping("/materii/{id}")
    public ResponseEntity<Optional<List<Profesor>>> getMateriiByProfesorId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(profesorService.findMaterieByProfesorId(id));
    }
}
