package ro.devmind.demohibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.devmind.demohibernate.models.Materie;
import ro.devmind.demohibernate.models.Profesor;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    @Query(value = "SELECT p.* from profesori p INNER JOIN materii m ON m.id_profesor = p.id WHERE p.id = :id", nativeQuery = true)
    Optional<List<Profesor>> findMaterieByProfesorId(Integer id);
}
