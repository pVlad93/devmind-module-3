package ro.devmind.demohibernate.assemblers;

import lombok.NonNull;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ro.devmind.demohibernate.dtos.StudentDto;
import ro.devmind.demohibernate.models.Student;

import java.util.List;

@Component
public class StudentAssembler implements RepresentationModelAssembler<Student, StudentDto> {
    @Override
    public @NonNull StudentDto toModel(@NonNull Student entity) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(entity.getId());
        studentDto.setNume(entity.getNume());
        studentDto.setPrenume(entity.getPrenume());

        if (null != entity.getAdresa()) {
            studentDto.setLocalitate(entity.getAdresa().getLocalitate());
            studentDto.setStrada(entity.getAdresa().getStrada());
        }

        return studentDto;
    }

    public List<StudentDto> toModelList(List<Student> entities) {
        return entities.stream().map(this::toModel).toList();
    }
}
