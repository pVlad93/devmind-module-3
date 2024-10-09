package beans;

import interfaces.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements ITeacher {
    private static final String MATH_TEACHER_PREFIX = "Math teacher says: ";
    private WisdomWordsService wisdomWordsService;
    @Override
    public String getHomework() {

        return "Solve 100 problems";
    }

    @Override
    public String getWisdom() {

        return MATH_TEACHER_PREFIX + this.wisdomWordsService.getMessage();
    }

    @Autowired
    public void setWisdomWordsService(WisdomWordsService wisdomWordsService) {
        this.wisdomWordsService = wisdomWordsService;
    }
}
