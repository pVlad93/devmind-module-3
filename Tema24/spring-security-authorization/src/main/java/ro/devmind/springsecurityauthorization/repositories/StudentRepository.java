package ro.devmind.springsecurityauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.devmind.springsecurityauthorization.models.Materie;
import ro.devmind.springsecurityauthorization.models.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);

    Optional<Student> findByNameAndFirstName(String name, String firstName);

    Optional<Student> findByNameContaining(String fistName);

    List<Student> findAllByNameContaining(String name);

    List<Student> findAllByAdresa_CityOrderByIdDesc(String city);
    @Query("SELECT s.materii FROM Student s WHERE s.name = :studentName")
    Set<Materie> findMateriiByName(String studentName);
}
