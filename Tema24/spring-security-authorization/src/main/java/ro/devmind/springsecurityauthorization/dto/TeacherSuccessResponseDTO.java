package ro.devmind.springsecurityauthorization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ro.devmind.springsecurityauthorization.models.Materie;

import java.util.Set;

@AllArgsConstructor
@Getter
public class TeacherSuccessResponseDTO {

    private long id;
    private String name;
    private Set<Materie> courses;
}
