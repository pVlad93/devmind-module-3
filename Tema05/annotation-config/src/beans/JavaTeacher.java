package beans;

import interfaces.ITeacher;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JavaTeacher implements ITeacher {

    private int age;
    private String workPlace;
    @Setter
    private WisdomWordsService wisdomWordsService;
    private final HomeworkService homeworkService;

    @Autowired
    public JavaTeacher(WisdomWordsService wisdomWordsService, HomeworkService homeworkService) {
        System.out.println("wisdomWordsService: " + wisdomWordsService + " wisdom: " + wisdomWordsService.getMessage());
        this.wisdomWordsService = wisdomWordsService;
        this.homeworkService = homeworkService;
    }

    @Value("${teacher.age}")
    public void setAge(int age) {
        this.age = age;
    }

    @Value("${workplace.name}")
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @Override
    public String getHomework() {

        return this.homeworkService.getHomework();
    }

    @Override
    public String getWisdom() {
        return this.wisdomWordsService.getMessage();
    }
}
