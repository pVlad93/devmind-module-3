package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Motor {
    @Value("150")
    private int putere;
    @Value("engineName")
    private String nume;
    @Value("3")
    private int numarCilindri;
}
