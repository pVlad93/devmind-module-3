package ro.devmind.demohibernate.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.devmind.demohibernate.models.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    Optional<Student> findByNume(String nume);

    Optional<Student> findByNumeAndPrenume(String nume, String prenume);

    Optional<Student> findByPrenumeContaining(String prenume);

    List<Student> findAllByNumeContaining(String nume);

    List<Student> findAllByAdresa_LocalitateOrderById(String localitate);

    @Query(value = "SELECT s from Student s WHERE s.adresa.localitate = :localitate ORDER BY s.id DESC ")
    List<Student> findAllStudentByLocalitate(String localitate);

    @Query(value = "SELECT s.* from studenti s INNER JOIN adrese a ON a.id = s.id_adresa WHERE a.localitate = :city ORDER BY s.id DESC", nativeQuery = true)
    List<Student> findAllStudentsByCityNative(String city);

}
