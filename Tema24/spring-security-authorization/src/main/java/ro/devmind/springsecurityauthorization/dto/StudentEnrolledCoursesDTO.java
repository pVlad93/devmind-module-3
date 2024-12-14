package ro.devmind.springsecurityauthorization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ro.devmind.springsecurityauthorization.models.Materie;

import java.util.Set;

@Getter
@AllArgsConstructor
public class StudentEnrolledCoursesDTO {
    private Set<Materie> materii;
}
