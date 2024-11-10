package edu.devmind.spring_boot.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devmind.spring_boot.views.Views;
import lombok.Data;

@Data
public class MathOperation {
    private double firstNumber;
    private double secondNumber;
    private String operation;
    @JsonView(Views.Public.class)
    private double result;

    public void doOperation() {
        switch (operation) {
            case "sum" -> this.result = firstNumber + secondNumber;
            case "difference" -> this.result = firstNumber - secondNumber;
            case "multiply" -> this.result = firstNumber * secondNumber;
            case "divide" -> this.result = firstNumber / secondNumber;
            case "power" -> this.result = Math.pow(firstNumber, secondNumber);
        };
    }
}
