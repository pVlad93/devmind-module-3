package beans;

import org.springframework.stereotype.Component;

@Component
public class WisdomWordsService {
    private String message = "Hard work pays off";

    public WisdomWordsService() {
        System.out.println("Constructing");
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
