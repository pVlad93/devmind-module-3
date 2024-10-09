package beans;

import org.springframework.stereotype.Component;

@Component
public class HomeworkService {
    public String getHomework() {
        return "Write 100 exercises";
    }
}
