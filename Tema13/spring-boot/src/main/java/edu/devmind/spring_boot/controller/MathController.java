package edu.devmind.spring_boot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.devmind.spring_boot.pojo.MathOperation;
import edu.devmind.spring_boot.views.Views;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @PostMapping("/math-service")
    public String mathService(@RequestBody MathOperation mathOperation) {
        try {
            mathOperation.doOperation();
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            return mapper.writerWithView(Views.Public.class).writeValueAsString(mathOperation);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
