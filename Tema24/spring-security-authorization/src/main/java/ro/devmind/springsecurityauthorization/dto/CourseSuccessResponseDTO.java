package ro.devmind.springsecurityauthorization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CourseSuccessResponseDTO {
    private String name;
    private String profesorName;
}
