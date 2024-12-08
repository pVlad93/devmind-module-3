package ro.devmind.demohibernate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.devmind.demohibernate.assemblers.StudentAssembler;
import ro.devmind.demohibernate.dtos.StudentDto;
import ro.devmind.demohibernate.models.Adresa;
import ro.devmind.demohibernate.models.Student;
import ro.devmind.demohibernate.services.StudentService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentAssembler studentAssembler;

    private Logger logger = Logger.getLogger(StudentController.class.getName());

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudentsByCity(@RequestParam(required = false) String city,
                                                              @RequestParam(required = false) int pageNumber) {
        logger.info("*** StudentController.getStudentsByCity - find students in city: " + city);
        List<Student> students = studentService.getStudentsByCity(city, pageNumber);
        return ResponseEntity.ok(studentAssembler.toModelList(students));
    }

    // 2
    @PostMapping("/enroll")
    public ResponseEntity enrollStudentToMaterie(@RequestParam(name = "studentId") Integer studentId,
                                                 @RequestParam(name = "materieId") Integer materieId) {
        studentService.enrollStudentToMaterie(studentId, materieId);
        return ResponseEntity.ok(null);
    }

    // 3
    @PostMapping
    public ResponseEntity saveNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok(null);
    }

    // 4
    @PutMapping("/{studentId}/adresa")
    public ResponseEntity updateAdress(@PathVariable(name = "studentId") Integer studentId, @RequestBody Adresa adresa) {
        studentService.updateAdresa(studentId, adresa);
        return ResponseEntity.ok(null);
    }

    // 5
    @DeleteMapping("/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable(name = "studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(null);
    }
}
