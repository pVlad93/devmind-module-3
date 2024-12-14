package ro.devmind.springsecurityauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.devmind.springsecurityauthorization.models.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    Profesor findByName(String name);
}
