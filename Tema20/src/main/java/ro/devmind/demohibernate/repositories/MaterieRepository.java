package ro.devmind.demohibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.devmind.demohibernate.models.Materie;

public interface MaterieRepository extends JpaRepository<Materie, Integer> {
}
