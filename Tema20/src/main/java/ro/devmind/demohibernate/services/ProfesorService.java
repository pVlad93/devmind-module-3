package ro.devmind.demohibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.devmind.demohibernate.models.Materie;
import ro.devmind.demohibernate.models.Profesor;
import ro.devmind.demohibernate.repositories.ProfesorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }


    public Optional<Profesor> findById(Integer id) {
        return profesorRepository.findById(id);
    }

    public Optional<List<Profesor>> findMaterieByProfesorId(Integer id) {
        return profesorRepository.findMaterieByProfesorId(id);
    }
}
