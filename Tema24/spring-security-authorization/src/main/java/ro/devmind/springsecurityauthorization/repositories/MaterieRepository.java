package ro.devmind.springsecurityauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.devmind.springsecurityauthorization.models.Materie;

import java.util.Optional;

public interface MaterieRepository extends JpaRepository<Materie, Integer> {
    Optional<Materie> findByName(String name);
}
