package ro.devmind.demohibernate.services;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ro.devmind.demohibernate.models.Adresa;
import ro.devmind.demohibernate.models.Materie;
import ro.devmind.demohibernate.models.Student;
import ro.devmind.demohibernate.repositories.MaterieRepository;
import ro.devmind.demohibernate.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final MaterieRepository materieRepository;

    public List<Student> getStudentsByCity(final String city, int pageNumber) {
        List<Student> students = new ArrayList<>();

        // JPA query method
//        students = studentRepository.findAllByAdresa_CityOrderById(city);

        // JPQL
//        students = studentRepository.findAllStudentByCity(city);

        // SQL native query
//        students = studentRepository.findAllStudentsByCityNative(city);

        // JPA Specification (using Criteria Query)
        students = getStudentsSpecification(city, pageNumber).stream().toList();

        return students;
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public void enrollStudentToMaterie(Integer studentId, Integer materieId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Materie materie = materieRepository.findById(materieId).orElseThrow(() -> new RuntimeException("Materie not found"));

        student.getMaterii().add(materie);
        studentRepository.save(student);
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateAdresa(Integer studentId, Adresa adresa) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setAdresa(adresa);
        studentRepository.save(student);
    }

    private Page<Student> getStudentsSpecification(final String city, int pageNumber) {
        Specification<Student> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (null != city) {
                predicates.add(criteriaBuilder.equal(root.get("adresa").get("city"), city));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Student> page = studentRepository.findAll(specification, PageRequest.of(pageNumber, 2));
        return page;
    }


    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
