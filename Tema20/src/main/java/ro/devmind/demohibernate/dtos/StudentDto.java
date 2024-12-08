package ro.devmind.demohibernate.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class StudentDto extends RepresentationModel<StudentDto> {
    private Integer id;
    private String nume;
    private String prenume;
    private String strada;
    private String localitate;
}
