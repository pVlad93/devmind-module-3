package ro.devmind.springsecurityauthorization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TeacherRequestDTO {

    private String teacherName;
    private String courseName;
}
