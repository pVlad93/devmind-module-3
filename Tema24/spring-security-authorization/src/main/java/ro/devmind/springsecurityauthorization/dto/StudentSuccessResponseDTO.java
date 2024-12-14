package ro.devmind.springsecurityauthorization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentSuccessResponseDTO {
    private String studentName;
    private String materieName;

}
